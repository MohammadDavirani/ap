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
    public void setStudent(List<Student> students){
        this.studentManager.setStudents(students);
    }
    public List<Book> getBooks(){
        return this.bookManager.getBooks();
    }
    public void setBook(List<Book> books){
        this.bookManager.setBooks(books);
    }
    public int getStudentCount() {
        return this.studentManager.getStudentCount();
    }

    //--------------------------------------------------------------------
    public void registerStudent(String name, String studentId, String username, String password) {
        studentManager.registerStudent(name, studentId, username, password);
    }
    public Student authenticateStudent(String username, String password) {
        return studentManager.authenticateStudent(username, password);
    }
    public void editStudentInformation(Student student) {
        System.out.println("Not implemented.");
    }
    public void borrowBook(Student student) {
        System.out.println("Not implemented.");
    }
    public void returnBook(Student student) {
        System.out.println("Not implemented.");
    }
    public void displayAvailableBooks() {
        bookManager.getBooks().stream().
                filter(s-> s.getExist()).
                forEach(System.out::println);
    }
    public void start() {
        menuHandler.displayMainMenu();
    }

    public void searchingBook(){
        System.out.println("== searching book box ==");
        System.out.println("1.search by title and author");
        System.out.println("2.search by title and year Of publishing");
        System.out.println("3.search by author and year of publishing");
        System.out.println("4.Exit");
        System.out.print("Please enter your choice: ");
        int choice = menuHandler.getIntInput(1, 5);

        String title,author,yearOfPublishing;

        switch(choice){
            case 1:
                System.out.println("enter title:");
                title = scanner.nextLine();

                System.out.println("enter author:");
                author = scanner.nextLine();

                bookManager.getBooks().stream()
                        .filter(s -> s.getTitle().equals(title) && s.getAuthor().equals(author))
                        .forEach(s-> System.out.println(s));

                break;

            case 2:
                System.out.println("enter author:");
                author = scanner.nextLine();

                System.out.println("enter year Of Publishing:");
                yearOfPublishing = scanner.nextLine();

                bookManager.getBooks().stream()
                        .filter(s -> s.getAuthor().equals(author) && s.getYearOfPublishing().equals(yearOfPublishing))
                        .forEach(s-> System.out.println(s));
                break;

            case 3:
                System.out.println("enter year Of Publishing:");
                yearOfPublishing = scanner.nextLine();

                System.out.println("enter author:");
                author = scanner.nextLine();

                bookManager.getBooks().stream()
                        .filter(s -> s.getAuthor().equals(author) && s.getYearOfPublishing().equals(yearOfPublishing))
                        .forEach(s-> System.out.println(s));
                break;

            case 4:
                System.out.println("exiting");
                return;


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
