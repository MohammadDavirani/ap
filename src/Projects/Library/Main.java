package Projects.Library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library("University of zanjan");
        FileStorageHandler storageHandler =new FileStorageHandler();
        storageHandler.loadLibraryData(library);

        InputHandler handler = new InputHandler();
        Scanner input = new Scanner(System.in);
        Menu menu =new Menu();

        libraryAdmin admin = handler.getLibraryAdminInfoFromUser();
        Student student = handler.getStudentInfoFromUser();
        Book book = handler.getBookInfoFromUser();

        library.addStudent(student);
        admin.addBookToLibrary(library,book);

        if (library.getArrayLibraryManagers().isEmpty()) {
            libraryManager manager1 = handler.getManagerInfoFromUser();
            libraryManager manager2 = handler.getManagerInfoFromUser();
            library.addManager(manager1);
            library.addManager(manager2);
        }

        System.out.println("Choose your role:\n1. Student\n2. Admin");
        int choice = input.nextInt();
        switch(choice){
            case 1:
                menu.showStudentMenu();
                break;

            case 2:
                menu.showAdminMenu();
                break;

            default:
                System.out.println("Invalid choice!");
                break;
        }

        storageHandler.saveLibraryData(library);
    }
}
