package Projects.finalproject;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class LibrarySystem implements Serializable {
    private StudentManager studentManager;
    private MenuHandler menuHandler;
    private BookManager bookManager;
    private Scanner scanner;

    //--------------------------------------------------------------------
    public LibrarySystem() {
        this.studentManager = new StudentManager();
        this.bookManager = new BookManager();
        this.menuHandler = new MenuHandler(this);
        this.scanner = new Scanner(System.in);

    }


    public List<Student> getStudents(){
        return this.studentManager.getStudents();
    }
    public List<BooksRequested> getRequests(){
        return this.studentManager.getBooksRequested();
    }
    public List<Book> getBooks(){
        return this.bookManager.getBooks();
    }
    public int getStudentCount() {
        return this.studentManager.getStudentCount();
    }

    public void setBookRequests(List<BooksRequested> bookRequests){
        this.studentManager.setBooksRequested(bookRequests);
    }
    public void setStudent(List<Student> students){
        this.studentManager.setStudents(students);
    }
    public void setBook(List<Book> books){
        this.bookManager.setBooks(books);
    }

    //--------------------------------------------------------------------
    public void registerStudent(String name, String studentId, String username, String password, boolean borrowRequest) {
        studentManager.registerStudent(name, studentId, username, password, borrowRequest);
    }
    public Student authenticateStudent(String username, String password) {
        return studentManager.authenticateStudent(username, password);
    }
    public void editStudentInformation(Student student) {
        System.out.println("== Editing box ==");
        System.out.println("1. edit name");
        System.out.println("2. edit id");
        System.out.println("3. edit username");
        System.out.println("4. edit password");
        System.out.println("5.Exit");
        System.out.print("Please enter your choice: ");
        int choice = menuHandler.getIntInput(1, 5);
        String newName,newId,newUsername,newPassword;

        switch(choice){
            case 1:
                System.out.println("enter new name:");
                newName = scanner.nextLine();
                student.setName(newName);
                System.out.println("Student information editing successfully.");
                break;

            case 2:
                System.out.println("enter new Id:");
                newId = scanner.nextLine();
                student.setStudentId(newId);
                System.out.println("Student information editing successfully.");
                break;

            case 3:
                System.out.println("enter new Username:");
                newUsername = scanner.nextLine();
                student.setUsername(newUsername);
                System.out.println("Student information editing successfully.");
                break;

            case 4:
                System.out.println("enter new Password:");
                newPassword = scanner.nextLine();
                student.setPassword(newPassword);
                System.out.println("Student information editing successfully.");
                break;

            case 5:
                System.out.println("Exiting from editing information");
                break;

            default:
                System.out.println("Invalid option! Please try again.");
        }
    }
    public void borrowBook(Student student) {
        if(!student.isBorrowRequest()){
            Book requestBook = searchingBook();
            if(requestBook == null){
            }else{
                if(requestBook.getExist()){
                    System.out.println("book is available");
                    System.out.println("Do you want to register your request?(yes/no)");
                    String question = scanner.nextLine();
                    if(question.equalsIgnoreCase("yes")){
                        student.setBorrowRequest(true);
                        BooksRequested requested = new BooksRequested(student,requestBook);
                        studentManager.addToRequestList(requested);
                        System.out.println("The request was successfully submitted. ");
                    }else{
                        System.out.println("exit from request");
                    }
                }
                else{
                    System.out.println("this book is not available");
                }
            }

        }else{
            System.out.println("Book request registration is active for you.");
        }
    }
    public void returnBook(Student student) {
        System.out.println("Not implemented.");
    }
    public void displayAvailableBooks() {
        bookManager.getBooks().stream().
                filter(Book::getExist).
                forEach(System.out::println);
    }
    public void start() {
        menuHandler.displayMainMenu();
    }

    public Book searchingBook(){
        System.out.println("== searching book box ==");
        System.out.println("1.search by title and author");
        System.out.println("2.search by title and year Of publishing");
        System.out.println("3.search by author and year of publishing");
        System.out.println("4.Exit");
        System.out.print("Please enter your choice: ");
        int choice = menuHandler.getIntInput(1, 4);

        String title,author,yearOfPublishing;

        switch(choice){
            case 1:
                System.out.println("enter title:");
                title = scanner.nextLine();

                System.out.println("enter author:");
                author = scanner.nextLine();

                return bookManager.getBooks().stream()
                        .filter(s -> s.getTitle().equalsIgnoreCase(title.trim()) && s.getAuthor().equalsIgnoreCase(author.trim()))
                        .findFirst()
                        .orElse(null);

            case 2:
                System.out.println("enter title");
                title = scanner.nextLine();

                System.out.println("enter year Of Publishing:");
                yearOfPublishing = scanner.nextLine();

                return bookManager.getBooks().stream()
                        .filter(s -> s.getTitle().equalsIgnoreCase(title.trim()) && s.getYearOfPublishing().equalsIgnoreCase(yearOfPublishing.trim()))
                        .findFirst()
                        .orElse(null);

            case 3:
                System.out.println("enter year Of Publishing:");
                yearOfPublishing = scanner.nextLine();

                System.out.println("enter author:");
                author = scanner.nextLine();

                return bookManager.getBooks().stream()
                        .filter(s -> s.getAuthor().equalsIgnoreCase(author.trim()) && s.getYearOfPublishing().equalsIgnoreCase(yearOfPublishing.trim()))
                        .findFirst()
                        .orElse(null);

            case 4:
                System.out.println("exiting");
                break;


            default:
                System.out.println("Invalid option! Please try again.");
        }
        return null;
    }
    public Book searchWithTitle(){
        System.out.println("Enter Title:");
        String title = scanner.nextLine();
        return bookManager.getBooks().stream()
                .filter(s->s.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }


    public void informationMode(){
        System.out.println("=== information mode ===");
        System.out.println("1. all student count");
        System.out.println("2. all book count");
        System.out.println("3. all borrow book count");
        System.out.println("4. all new borrow book count");
        System.out.println("5.Exit");

        System.out.print("Please enter your choice: ");
        int choice = menuHandler.getIntInput(1, 5);

        switch(choice){
            case 1:
                System.out.println("all student count : " + getStudentCount());
                break;

            case 2:
                System.out.println("all book count : " + getBooks().size());
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

    //--------------------------------------------------------------------
    public static void main(String[] args) {
        dataFile file = new dataFile();
        LibrarySystem system = new LibrarySystem();
        file.loadLibraryDataFromFile(system);
        system.start();
        file.saveLibraryDataToFile(system);
    }
}
