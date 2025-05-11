package Projects.Library;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class libraryManager {
    private String firstName;
    private String lastName;
    private int userId;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void searchingBook(){

    }

    public void BookDelivery(){

    }

    public static libraryManager getRandomManager(){
        library library = new library();
        Random random = new Random();
        ArrayList<libraryManager> managers = library.getArrayLibraryManagers();
        libraryManager randomManager = managers.get(random.nextInt(managers.size()));
        return randomManager;
    }
}
