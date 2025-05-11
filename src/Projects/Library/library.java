package Projects.Library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class library {
    private String libraryName;
    public library(String libraryName) {
        this.libraryName = libraryName;
    }
    public library(){

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


    public void borrowBook(Student student,Book book){
        if(!book.isToExist()) {
            System.out.println("is not exist!");
            return;
        }

        libraryManager randomManager=libraryManager.getRandomManager();

        bookLoan loan = new bookLoan();
        loan.setBookLoan(book);
        loan.setStudentBookLoan(student);
        loan.setGiverManager(randomManager);
        loan.setBorrowDate(LocalDate.now());
        loan.setDueDate(LocalDate.now().plusDays(20));

        addLoan(loan);

        book.setToExist(false);

    }
    public void returnBook(Student student,Book book){
        for(int i=0;i< this.getArrayBookLoans().size();i++){
            bookLoan loan = this.getArrayBookLoans().get(i);

            if (loan.getBookLoan().equals(book) && loan.getStudent().equals(student)) {
                loan.getBookLoan().setToExist(true);
            }
        }
    }

}
