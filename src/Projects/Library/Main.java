package Projects.Library;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        library library = new library("University of zanjan");

        libraryAdmin admin = InputHandler.getLibraryAdminInfoFromUser();

        libraryManager manager1 = InputHandler.getManagerInfoFromUser();
        libraryManager manager2 = InputHandler.getManagerInfoFromUser();
        library.addManager(manager1);
        library.addManager(manager2);

        Student student = InputHandler.getStudentInfoFromUser();
        library.addStudent(student);

        Book book = InputHandler.getBookInfoFromUser();

        admin.addBookToLibrary(library,book);



    }
}
