package Projects.finalproject;

import java.io.Serializable;
import java.util.Scanner;

public class MenuHandler implements Serializable {
    private Scanner scanner;
    private LibrarySystem librarySystem;
    private Student currentUser;
    private Admin currentAdminUser;

    public MenuHandler(LibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
        this.currentUser = null;
        this.scanner = new Scanner(System.in);
        this.currentAdminUser = null;
    }

    public void displayMainMenu() {
        while (true) {
            System.out.println("\n=== University Library Management System ===");
            System.out.println("1. Student Registration");
            System.out.println("2. Student Login");
            System.out.println("3. View Registered Student Count");
            System.out.println("4. Log in as a guest");
            System.out.println("5. log in as a manager");
            System.out.println("6. log in as an admin");
            System.out.println("7. Exit");
            System.out.print("Please enter your choice: ");

            int choice = getIntInput(1, 7);

            switch (choice) {
                case 1:
                    handleStudentRegistration();
                    break;
                case 2:
                    handleStudentLogin();
                    break;
                case 3:
                    displayStudentCount();
                    break;
                case 4:
                    handleGuestLogin();
                    break;
                case 5:
                    handleManagerRegistration();
                    break;
                case 6:
                    handleAdminLogin();
                    break;
                case 7:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
            System.out.println("___________________________");
        }
    }

    private void displayStudentCount() {
        int studentCount = librarySystem.getStudentCount();
        System.out.println("\nTotal registered students: " + studentCount);
    }

    private void handleStudentRegistration() {
        System.out.println("\n--- New Student Registration ---");

        System.out.print("Student name: ");
        String name = scanner.nextLine();

        System.out.print("Student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        boolean borrowRequest = false;

        librarySystem.registerStudent(name, studentId, username, password, borrowRequest);
    }

    private void handleAdminRegistration(){
        System.out.println("\n--- New Admin Registration ---");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        librarySystem.registerAdmin(username, password);
    }

    private void handleManagerRegistration(){
        System.out.println("=== Manager Menu ===");
        System.out.println("1. admin registration");
        System.out.println("2. view admins ");
        System.out.println("3. view information borrow books ");
        System.out.println("4. view students information  ");
        System.out.println("5. Exit");
        System.out.print("Please enter your choice: ");

        int choice = getIntInput(1, 5);

        switch(choice){
            case 1:
                handleAdminRegistration();
                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                System.out.println("Exiting");
                break;

            default:
                System.out.println("Invalid option! Please try again.");
        }

    }

    private void handleStudentLogin() {
        System.out.println("\n--- Student Login ---");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        currentUser = librarySystem.authenticateStudent(username, password);

        if (currentUser != null) {
            System.out.println("Login successful! Welcome, " + currentUser.getName());
            displayLoggedInStudentMenu();
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private void handleAdminLogin(){
        System.out.println("\n--- Admin Login ---");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        currentAdminUser = librarySystem.authenticateAdmin(username,password);

        if (currentUser != null) {
            System.out.println("Login successful! Welcome, " + currentUser.getName());
            displayLoggedInAdminMenu();
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private void displayLoggedInAdminMenu(){
        while (currentAdminUser != null) {
            System.out.println("\n=== Admin Dashboard ===");
            System.out.println("1. change password");
            System.out.println("2. add book");
            System.out.println("3. edit book information");
            System.out.println("4. Checking the book loan request");
            System.out.println("5. View student loan history information");
            System.out.println("6. Activating and deactivating a student");
            System.out.println("7. Receiving a borrowed book");
            System.out.println("8. Logout");
            System.out.print("Please enter your choice: ");

            int choice = getIntInput(1, 8);

            switch (choice) {
                case 1:
                    System.out.println("Enter new password: ");
                    currentAdminUser.setPassword(scanner.nextLine());
                    break;
                case 2:
                    librarySystem.addBook(currentAdminUser);
                    break;
                case 3:
                    librarySystem.editBookInformation(currentAdminUser);
                    break;
                case 4:
                    librarySystem.returnBook(currentUser);
                    break;
                case 5:
                    librarySystem.displayAvailableBooks();
                    break;
                case 6:
                    librarySystem.searchingBook();
                    break;
                case 8:
                    currentUser = null;
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private void displayLoggedInStudentMenu() {
        while (currentUser != null) {
            System.out.println("\n=== Student Dashboard ===");
            System.out.println("1. View My Information");
            System.out.println("2. Edit My Information");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. View Available Books");
            System.out.println("6. searching Book");
            System.out.println("7. Logout");
            System.out.print("Please enter your choice: ");

            int choice = getIntInput(1, 7);

            switch (choice) {
                case 1:
                    System.out.println("\n--- My Information ---");
                    System.out.println(currentUser);
                    break;
                case 2:
                    librarySystem.editStudentInformation(currentUser);
                    break;
                case 3:
                    librarySystem.borrowBook(currentUser);
                    break;
                case 4:
                    librarySystem.returnBook(currentUser);
                    break;
                case 5:
                    librarySystem.displayAvailableBooks();
                    break;
                case 6:
                    librarySystem.searchingBook();
                    break;
                case 7:
                    currentUser = null;
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private void handleGuestLogin(){
        System.out.println("=== Guest Menu ===");
        System.out.println("1. View Registered Student Count");
        System.out.println("2. search a book just title");
        System.out.println("3. view all information count");
        System.out.println("4. exit");
        System.out.print("Please enter your choice: ");

        int choice = getIntInput(1, 4);

        switch(choice){
            case 1:
                displayStudentCount();
                break;

            case 2:
                System.out.println(librarySystem.searchWithTitle());
                break;

            case 3:
                librarySystem.informationMode();
                break;

            case 4:
                System.out.println("Exiting guest mode!");
                break;

            default:
                System.out.println("Invalid option! Please try again.");
        }
    }

    public int getIntInput(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.printf("Please enter a number between %d and %d: ", min, max);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}