package Projects.Library;

import java.util.ArrayList;

public class library {
    private String libraryName;

    ArrayList<Book> ArrayBooks = new ArrayList<>();
    ArrayList<Student> ArrayStudents = new ArrayList<>();
    ArrayList<libraryManager> ArrayLibraryManagers = new ArrayList<>();
    ArrayList<bookLoan> ArrayBookLoans = new ArrayList<>();

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }
    public void addBook(Book book){
        this.ArrayBooks.add(book);
    }
    public void addStudent(Student student){
        this.ArrayStudents.add(student);
    }
    public void addManager(libraryManager manager){
        this.ArrayLibraryManagers.add(manager);
    }
    public void addLoan(bookLoan bookloan){
        this.ArrayBookLoans.add(bookloan);
    }

    public ArrayList<Book> getArrayBooks() {
        return ArrayBooks;
    }
    public ArrayList<Student> getArrayStudents() {
        return ArrayStudents;
    }
    public ArrayList<libraryManager> getArrayLibraryManagers() {
        return ArrayLibraryManagers;
    }
    public ArrayList<bookLoan> getArrayBookLoans() {
        return ArrayBookLoans;
    }

}
