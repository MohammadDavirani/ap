package exercises.EX6_SC3;

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
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main_EX6_SC3 {

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
                .filter(s -> !s.contains("rccp"))
                .collect(Collectors.toList());
        return urls;
    }

    public static List<String> getImageUrlsFromHtmlLines(List<String> htmlLines) {
        List<String> urls =  htmlLines.stream()
                .flatMap(s -> getAllSrcAttributes(s).stream())
                .filter(Objects::nonNull)
                .filter(s -> !s.isEmpty())
                .filter(s -> s.matches(".*\\.(jpg|jpeg|png|gif|bmp|webp)$"))
                .distinct()
                .collect(Collectors.toList());
        return urls;
    }

    public static List<String> getSongUrlsFromHtmlLines(List<String> htmlLines) {
        List<String> urls =  htmlLines.stream()
                .flatMap(s -> getAllSrcAttributes(s).stream())
                .filter(Objects::nonNull)
                .filter(s -> !s.isEmpty())
                .filter(s -> s.matches(".*\\.(mp3|wav|ogg|m4a|mp4)$"))
                .distinct()
                .collect(Collectors.toList());
        return urls;
    }


    public static List<String> getAllSrcAttributes(String htmlLine) {
        List<String> srcList = new ArrayList<>();
        int index = 0;
        while ((index = htmlLine.indexOf("src=\"", index)) != -1) {
            index += 5;
            int endIndex = htmlLine.indexOf("\"", index);
            if (endIndex != -1) {
                String src = htmlLine.substring(index, endIndex);
                srcList.add(src);
                index = endIndex;
            }
        }
        return srcList;
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
                    System.out.println("The folder "+urls.get(i)+" was created");
                }
                try {
                    URL pageLocation = new URL(urls.get(i));
                    Scanner in = new Scanner(pageLocation.openStream());
                    List<String> htmlLines=new ArrayList<>();
                    while (in.hasNext()){
                        htmlLines.add(in.next());
                    }
                    in.close();
                    String filePath = folderPath + "\\" + Subdomain +"HTML"+".txt";
                    String filePathImage = folderPath + "\\" + Subdomain + "Image"+ ".txt";
                    String filePathSong = folderPath + "\\" + Subdomain + "Song"+ ".txt";

                    try{
                        FileWriter writer = new FileWriter(filePath);
                        for (String line : htmlLines) {
                            if(!line.isEmpty()){
                                writer.write(line+"\n");
                            }
                        }
                        System.out.println("HTML file "+urls.get(i)+"was created");
                        writer.close();

                        List<String> image = getImageUrlsFromHtmlLines(htmlLines);

                        writer = new FileWriter(filePathImage);
                        for (String line : image) {
                            if(!line.isEmpty()){
                                writer.write(line+"\n");
                            }
                        }
                        System.out.println("Image file "+urls.get(i)+"was created");
                        writer.close();


                        List<String> song = getSongUrlsFromHtmlLines(htmlLines);

                        writer = new FileWriter(filePathSong);
                        for (String line : song) {
                            if(!line.isEmpty()){
                                writer.write(line+"\n");
                            }
                        }
                        System.out.println("Song file "+urls.get(i)+"was created");
                        writer.close();
                    }catch (IOException e){
                        System.out.println("Writing file failed for: "+ urls.get(i));
                    }

                } catch (IOException e) {
                    System.out.println("Unable to access " + urls.get(i) + ": " + e.getMessage());
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

            try {
                URL pageLocation = new URL(urlTemp.get(i));
                Scanner in = new Scanner(pageLocation.openStream());
                List<String> htmlLines=new ArrayList<>();
                while (in.hasNext()){
                    htmlLines.add(in.next());
                }
                in.close();
                String filePath = folderPath + "\\" + domain +"_HTML"+".txt";
                String filePathImage = folderPath + "\\" + domain + "_Image"+ ".txt";
                String filePathSong = folderPath + "\\" + domain + "_Song"+ ".txt";
                try{
                    FileWriter writer = new FileWriter(filePath);
                    for (String line : htmlLines) {
                        if(!line.isEmpty()){
                            writer.write(line+"\n");
                        }
                    }
                    System.out.println("HTML file "+urlTemp.get(i)+"was created");
                    writer.close();

                    List<String> image = getImageUrlsFromHtmlLines(htmlLines);

                    writer = new FileWriter(filePathImage);
                    for (String line : image) {
                        if(!line.isEmpty()){
                            writer.write(line+"\n");
                        }
                    }
                    System.out.println("Image file "+urlTemp.get(i)+"was created");
                    writer.close();

                    List<String> song = getSongUrlsFromHtmlLines(htmlLines);

                    writer = new FileWriter(filePathSong);
                    for (String line : song) {
                        if(!line.isEmpty()){
                            writer.write(line+"\n");
                        }
                    }
                    System.out.println("Song file "+urlTemp.get(i)+"was created");

                    writer.close();
                }catch (IOException e){
                    System.out.println("Error: "+e.getMessage());
                }

            }catch (IOException e){
                System.out.println("Unable to access " + urlTemp.get(i) + ": " + e.getMessage());

            }
        }
    }

    public static void main(String[] args) throws IOException {
        creatFoldersForUrl();
    }
}
