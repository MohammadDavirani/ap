package Projects.Library;

import java.util.ArrayList;

public class library {
    private String libraryName;

    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<libraryManager> libraryManagers = new ArrayList<>();
    ArrayList<bookLoan> bookLoans = new ArrayList<>();

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }
    public void addBook(Book book){
        this.books.add(book);
    }
    public void addStudent(Student student){
        this.students.add(student);
    }
    public void addManager(libraryManager manager){
        this.libraryManagers.add(manager);
    }
    public void addLoan(bookLoan bookloan){
        this.bookLoans.add(bookloan);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public ArrayList<libraryManager> getLibraryManagers() {
        return libraryManagers;
    }
    public ArrayList<bookLoan> getBookLoans() {
        return bookLoans;
    }
}
