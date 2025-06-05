package exercises.EX6_SC2;

import exercises.EX6_SC2.scraper.Conf;
import exercises.EX6_SC2.scraper.parser.HtmlParser;
import exercises.EX6_SC2.scraper.utils.DirectoryTools;
import exercises.EX6_SC2.scraper.utils.FileTools;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main_EX6_SC2 {
    private static List<String> fileList = DirectoryTools.getFilesAbsolutePathInDirectory(Conf.SAVE_DIRECTORY);

    public static List<String> getAllUrls() {
        List<String> urls = fileList.stream()
                .map(fileAddress -> FileTools.getTextFileLines(fileAddress))
                .filter(s -> s != null)
                .flatMap(s -> s.stream())
                .map(s -> HtmlParser.getFirstUrl(s))
                .filter(s -> s != null)
                .filter(s -> s.length() > 1)
                .filter(s -> s.contains("znu.ac.ir"))
                .filter(s -> !s.contains(".rar"))
                .filter(s -> !s.contains(".irl"))
                .collect(Collectors.toList());
        return urls;
    }

    public static void creatFoldersForUrl() throws IOException {
        List<String> urls = getAllUrls();
        List<String> urlTemp =new ArrayList<>();
        for (int i = 0; i < urls.size(); i++) {
            if((urls.get(i).startsWith("https://") || urls.get(i).startsWith("http://")) && (urls.get(i).endsWith(".znu.ac.ir") || urls.get(i).endsWith(".znu.ac.ir/"))&& !urls.get(i).contains("www")){
                int endIndex = urls.get(i).indexOf(".");
                String Subdomain = urls.get(i).substring(8,endIndex) + "_";

                String folderPath = "C:\\Users\\Huriyeh\\IdeaProjects\\java\\htmlUrls\\SubDomain\\" + Subdomain;
                File folder = new File(folderPath);
                if (!folder.exists()) {
                    folder.mkdirs();
                }

                URL pageLocation = new URL(urls.get(i));
                Scanner in = new Scanner(pageLocation.openStream());

                List<String> htmlLines=new ArrayList<>();
                while (in.hasNext()){
                    htmlLines.add(in.next());
                }
                in.close();

                String filePath = folderPath + "\\" + Subdomain + ".txt";

                try{
                    FileWriter writer = new FileWriter(filePath);
                    for (String line : htmlLines) {
                        if(!line.isEmpty()){
                            writer.write(line+"\n");
                        }
                    }
                    writer.close();
                }catch (IOException e){
                    System.out.println("Error: "+e.getMessage());
                }


            }

            if ((urls.get(i).startsWith("https://") || urls.get(i).startsWith("http://")) && (!urls.get(i).endsWith(".znu.ac.ir") || !urls.get(i).endsWith(".znu.ac.ir/")) && urls.get(i).contains("www")) {
                urlTemp.add(urls.get(i));
            }
        }
        urlTemp = urlTemp.stream()
                .distinct()
                .filter(s -> !s.contains("https://znu.ac.ir"))
                .filter(s -> !s.contains("http://znu.ac.ir"))
                .collect(Collectors.toList());
        for (int i = 0; i < urlTemp.size(); i++){


            int start = urlTemp.get(i).lastIndexOf("/")+1;
            int endIndex = urlTemp.get(i).length();
            String domain = urlTemp.get(i).substring(start,endIndex);

            String folderPath = "C:\\Users\\Huriyeh\\IdeaProjects\\java\\htmlUrls\\Domain\\" + domain;
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            URL pageLocation = new URL(urlTemp.get(i));
            Scanner in = new Scanner(pageLocation.openStream());

            List<String> htmlLines=new ArrayList<>();
            while (in.hasNext()){
                htmlLines.add(in.next());
            }
            in.close();

            String filePath = folderPath + "\\" + domain + ".txt";

            try{
                FileWriter writer = new FileWriter(filePath);
                for (String line : htmlLines) {
                    if(!line.isEmpty()){
                        writer.write(line+"\n");
                    }
                }
                writer.close();
            }catch (IOException e){
                System.out.println("Error: "+e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        creatFoldersForUrl();
    }

}
