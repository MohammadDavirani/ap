package Projects.Library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library("University of zanjan");
        libraryAdmin admin = new libraryAdmin();
        FileStorageHandler storageHandler =new FileStorageHandler();
        storageHandler.loadLibraryData(library,admin);

        InputHandler handler = new InputHandler();
        Scanner input = new Scanner(System.in);
        Menu menu =new Menu();
        if (library.getArrayLibraryManagers().isEmpty()) {
            libraryManager manager1 = handler.getManagerInfoFromUser();
            libraryManager manager2 = handler.getManagerInfoFromUser();
            library.addManager(manager1);
            library.addManager(manager2);
        }


        libraryManager manager = new libraryManager();
        int choice;
        do {
            System.out.println("Choose your role:\n1. Student\n2. Admin\n3. Manager");
            choice = input.nextInt();
            switch(choice){
                case 1:
                    menu.showStudentMenu(library);
                    break;

                case 2:
                    menu.showAdminMenu(library,admin);
                    break;

                case 3:
                    menu.showManagerMenu(library);
                    break;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }
            System.out.println("Do you have another request?\nyes=1\nno=2");
            choice = input.nextInt();
        }while(choice==1);

        storageHandler.saveLibraryData(library,admin);
    }
}
