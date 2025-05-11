package Projects.Library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        library library = new library();
        library.setLibraryName("University of zanjan");

        libraryAdmin admin = new libraryAdmin();
        admin.setFirstName("mohammad");
        admin.setLastName("dabiri");
        admin.setEducationLevel("Master");

        libraryManager manager1 = InputHandler.getManagerInfoFromUser();
        libraryManager manager2 = InputHandler.getManagerInfoFromUser();
        library.addManager(manager1);
        library.addManager(manager2);


        Student student = InputHandler.getStudentInfoFromUser();
        library.addStudent(student);

        Book book = InputHandler.getBookInfoFromUser();

        admin.addBookToLibrary(library,book);

        Random random = new Random();
        ArrayList<libraryManager> managers = library.getArrayLibraryManagers();
        libraryManager randomManager = managers.get(random.nextInt(managers.size()));
    }
}
