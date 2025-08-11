package Projects.finalproject;

import java.io.Serializable;
import java.util.List;

public class LibrarySystem implements Serializable {
    private StudentManager studentManager;
    private MenuHandler menuHandler;
    private BookManager bookManager;

    public LibrarySystem() {
        this.studentManager = new StudentManager();
        this.bookManager = new BookManager();
        this.menuHandler = new MenuHandler(this);
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

    }
    public void start() {
        menuHandler.displayMainMenu();
    }

    public static void main(String[] args) {
        dataFile file = new dataFile();
        LibrarySystem system = new LibrarySystem();
        file.loadLibraryDataFromFile(system);
        system.start();
        file.saveLibraryDataToFile(system);
    }
}
