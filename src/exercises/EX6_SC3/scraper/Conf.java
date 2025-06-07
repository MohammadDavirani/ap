package exercises.EX6_SC3.scraper;

import exercises.EX6_SC3.Main_EX6_SC3;

import java.io.IOException;


public class Conf {

    public static final String DOMAIN_ADDRESS = "https://znu.ac.ir";

    public static final String SAVE_DIRECTORY = "fetched_html";

    public static void Sleep(int k) throws InterruptedException, IOException {
        Main_EX6_SC3.creatFoldersForUrl();
        Thread.sleep(1000L * k);
    }
}
