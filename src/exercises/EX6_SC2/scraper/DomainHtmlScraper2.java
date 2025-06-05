package exercises.EX6_SC2.scraper;

import exercises.EX6_SC2.scraper.fetcher.HtmlFetcher;
import exercises.EX6_SC2.scraper.parser.HtmlParser;
import exercises.EX6_SC2.scraper.store.HtmlFileManager;

import java.io.IOException;
import java.util.*;

public class DomainHtmlScraper2 {
    private String domainAddress;
    private Queue<String> queue;

    private HtmlFileManager htmlFileManager;

    public DomainHtmlScraper2(String domainAddress, String savePath) {
        this.domainAddress = domainAddress;
        this.queue = new LinkedList<>();
        this.htmlFileManager=new HtmlFileManager(savePath);
    }

    public void start() throws IOException {
        Set<String> checked = new HashSet<>();      //***
        List<String> htmlLines = HtmlFetcher.fetchHtml(domainAddress);
        this.htmlFileManager.save(htmlLines);
        checked.add(domainAddress);                //***

        List<String> urls = HtmlParser.getAllUrlsFromList(htmlLines);
        queue.addAll(new HashSet<>(urls));
        int counter=1;

        while (!queue.isEmpty()){
            String url = queue.remove();
            if(checked.contains(url)){     //***
                continue;                  //***
            }                              //***
            counter++;
            try {
                htmlLines = HtmlFetcher.fetchHtml(url);      //***  Not domainAddress
                this.htmlFileManager.save(htmlLines);

                urls = HtmlParser.getAllUrlsFromList(htmlLines);
                queue.addAll(new HashSet<>(urls));
                checked.add(url);            //***
            }
            catch (Exception e){
                System.out.println("ERROR: "+url+"\t -> "+e.getMessage());
            }
            System.out.println("["+counter+"] "+url+" fetch and saved (queue size:"+queue.size()+").");
        }
        System.out.println("Operation complete");
    }

}