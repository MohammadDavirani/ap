package exercises.EX6_SC1;

import exercises.EX6_SC1.scraper.Conf;
import exercises.EX6_SC1.scraper.utils.DirectoryTools;
import exercises.EX6_SC1.scraper.utils.FileTools;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public class Main_EX6_SC1 {

    private static List<String> fileList = DirectoryTools.getFilesAbsolutePathInDirectory(Conf.SAVE_DIRECTORY);

    public static List<String> getAllUrls() {
        List<String> urls = fileList.stream()
                .map(fileAddress -> FileTools.getTextFileLines(fileAddress))
                .filter(s -> s != null)
                .flatMap(s -> s.stream())
                .map(s -> getFirstImageSrc(s))
                .filter(s -> s != null)
                .filter(s -> s.length() > 1)
                .filter(s -> !s.contains(".js"))
                .filter(s -> !s.contains(".mp4"))
                .distinct()
                .collect(Collectors.toList());
        return urls;
    }
    public static String getFirstImageSrc(String htmlLine) {
        String url = null;
        int startIndex = htmlLine.indexOf("src=\"");
        if (startIndex >= 0) {
            try {
                int srcLength = "src=\"".length();
                int endIndex = htmlLine.indexOf("\"", startIndex + srcLength + 1);
                url = htmlLine.substring(startIndex + srcLength + 1, endIndex);
            } catch (Exception e) {
            }
        }
        return url;
    }

    public static void saveImageUrls(){
        List<String> urls = getAllUrls();
        try{
            FileWriter writer = new FileWriter("ImageUrls.txt");
            for (String allUrl : urls) {
                writer.write(allUrl+"\n");
            }
            writer.close();
            System.out.println("Image Urls wrote to file Successful");
        }catch(IOException e){
            System.out.println("Error:"+e.getMessage());
        }
    }

    public static void main(String[] args) {
        saveImageUrls();
    }
}
