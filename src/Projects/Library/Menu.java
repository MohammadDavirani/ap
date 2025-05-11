package Projects.Library;

public class Menu {
    public static void showStudentMenu(){
        System.out.println("\n----- Student Menu -----");
        System.out.println("1. Search for a book");
        System.out.println("2. Borrow a book");
        System.out.println("3. Return a book");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    public static void showAdminMenu(){
        System.out.println("\n----- Admin Menu -----");
        System.out.println("1. Add new book");
        System.out.println("2. View overdue books");
        System.out.println("3. View number of loans by each staff member");
        System.out.println("4. View top 10 borrowed books in last year");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }
}
