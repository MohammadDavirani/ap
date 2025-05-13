package Projects.Library;

import java.util.Scanner;

public class Menu {
    public void showStudentMenu(){
        System.out.println("\n----- Student Menu -----");
        System.out.println("1. Search for a book");
        System.out.println("2. Borrow a book");
        System.out.println("3. Return a book");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
        Scanner input = new Scanner(System.in);
        int choose;
        Library library = new Library();
        libraryManager manager = new libraryManager();
        Student student = new Student();
        Book book = new Book();
        do{
            choose=input.nextInt();
            switch(choose){
                case 1:
                    String title,author;
                    title = input.nextLine();
                    author = input.nextLine();
                    library.searchBook(title,author);
                    break;

                case 2:
                    manager.borrowBook(library,student,book);
                    break;

                case 3:
                    manager.returnBook(library,student,book);
                    break;

                case 4:
                    System.out.println("See you later ;)");
                    break;

                default:
                    System.out.println("Invalid number!");
                    break;
            }

        }while(choose ==4);

    }
    public void showAdminMenu(){
        System.out.println("\n----- Admin Menu -----");
        System.out.println("1. Add new book");
        System.out.println("2. View overdue books");
        System.out.println("3. View number of loans by each staff member");
        System.out.println("4. View top 10 borrowed books in last year");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
        Scanner input = new Scanner(System.in);
        int choose;
        InputHandler handler = new InputHandler();
        Book book;
        Library library = new Library();
        libraryAdmin admin =new libraryAdmin();
        do{
            choose=input.nextInt();
            switch(choose){
                case 1:
                    book = handler.getBookInfoFromUser();
                    library.addBook(book);
                    break;

                case 2:
                    admin.listOfBooksBorrowed(library);
                    break;

                case 3:
                    library.countBooksLoans(library);
                    break;

                case 4:
                    library.top10BooksLastYear(library);
                    break;

                case 5:
                    System.out.println("See you later ;)");
                    break;

                default:
                    System.out.println("Invalid number!");
                    break;
            }

        }while(choose ==5);
    }
}
