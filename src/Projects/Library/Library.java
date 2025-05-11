package Projects.Library;

import java.util.ArrayList;

public class Library {
    private String libraryName;
    public Library(String libraryName) {
        this.libraryName = libraryName;
    }
    public Library(){

    }
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

    public void searchBook(String title,String author){
        boolean found = false;
        for(int i=0;i<ArrayBooks.size();i++){
            Book book = ArrayBooks.get(i);
            if(book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author)){
                System.out.println("Book found:");
                System.out.println(book);
                found = true;

            }
        }
        if (!found) {
            System.out.println("Book not found in library.");
        }
    }

}
