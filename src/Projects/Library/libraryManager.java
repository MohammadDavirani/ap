package Projects.Library;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class libraryManager {
    private String firstName;
    private String lastName;
    private long userId;

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public long getUserId() {
        return userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public libraryManager getRandomManager(Library library){
        Random random = new Random();
        ArrayList<libraryManager> managers = library.getArrayLibraryManagers();
        if (managers.isEmpty()) {
            System.out.println("No managers available.");
            return null;
        }
        return managers.get(random.nextInt(managers.size()));
    }

    public void borrowBook(Library library, Student student, Book book){
        if(!book.isToExist()) {
            System.out.println("is not exist!");
            return;
        }

        libraryManager randomManager= getRandomManager(library);

        BookLoan loan = new BookLoan();
        loan.setBookLoan(book);
        loan.setStudentBookLoan(student);
        loan.setGiverManager(randomManager);
        loan.setReceiverManager(null);
        loan.setBorrowDate(LocalDate.now());
        loan.setDueDate(LocalDate.now().plusDays(20));
        loan.incrementLoanCount();
        loan.setLaterTime(Period.ZERO);
        loan.setActualReturnTemp(Period.ZERO);
        library.addLoan(loan);

        book.setToExist(false);

    }

    public Book toExistBook(String title,String author,Library library){
        boolean found = false;
        for (int i = 0; i < library.getArrayBooks().size(); i++) {
            Book book = library.getArrayBooks().get(i);
            if (
                    (book.getTitle().toLowerCase().contains(title.toLowerCase())) &&
                            (book.getAuthor().toLowerCase().contains(author.toLowerCase())
                            && book.isToExist() == true) ){

                found = true;
                return book;
            }
        }
        return null;
    }
    public Student toExistStudent(Long studentId , Library library) {
        for (int i = 0; i < library.getArrayStudents().size(); i++) {
            Student student = library.getArrayStudents().get(i);
            if (studentId != null && studentId.equals(student.getStudentId())) {
                return student;
            }
        }
        return null;
    }
    public boolean studentRequest(Student student, Book book, List<Request> requestList) {
        for (Request req  : requestList) {
            if (req.getStudent().getStudentId().equals(student.getStudentId()) &&
                    req.getBook().getTitle().equals(book.getTitle())) {
                return true;
            }
        }
        return false;
    }

    public void borrowBookRequest(Library library,libraryManager manager){
        for(int i=0;i<library.getArrayRequest().size();i++){
            Request request = library.getArrayRequest().get(i);
            System.out.println(i+") "+request);
        }
        if(library.getArrayRequest().size()>0) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the student Id: ");
            int Number = input.nextInt();
            Book book = library.getArrayRequest().get(Number).getBook();
            library.getArrayBooks().get(Number).setToExist(false);
            Student student = library.getArrayRequest().get(Number).getStudent();
            library.getArrayRequest().remove(Number);
            BookLoan loan = new BookLoan();
            loan.setBookLoan(book);
            loan.setStudentBookLoan(student);
            loan.setGiverManager(manager);
            loan.setBorrowDate(LocalDate.now());
            loan.setDueDate(LocalDate.now().plusDays(20));
            loan.incrementLoanCount();
            library.addLoan(loan);
            System.out.println("The book was loaned");
        }
        else{
            System.out.println("There is no request!");
        }


    }

    public Book toExistReturnBookRequest(String title , String author , Library library){
        for(int i=0;i<library.getArrayBookLoans().size();i++){
            if(library.getArrayBookLoans().get(i).getBookLoan().getTitle().equalsIgnoreCase(title) &&
                    library.getArrayBookLoans().get(i).getBookLoan().getAuthor().equalsIgnoreCase(author)){
                return library.getArrayBookLoans().get(i).getBookLoan();
            }
        }
        return null;
    }
    public Student toExistReturnBookRequest(Long studentId , Library library){
        for(int i=0;i<library.getArrayBookLoans().size();i++){
            if(library.getArrayBookLoans().get(i).getStudent().getStudentId().equals(studentId)){
                return library.getArrayBookLoans().get(i).getStudent();
            }
        }
        return null;
    }
    public void ReturnBookRequest(Student student , Book book, Library library, libraryManager manager) {
        for(int i=0;i<library.getArrayBookLoans().size();i++){
            if(library.getArrayBookLoans().get(i).getStudent().equals(student)&&library.getArrayBookLoans().get(i).getBookLoan().equals(book) ){
                BookLoan loan = library.getArrayBookLoans().get(i);
                loan.setReceiverManager(manager);
                loan.setActualReturn(LocalDate.now());
                loan.setLaterTime(Period.between(loan.getActualReturn(),loan.getDueDate()));
                try{
                    FileWriter writer = new FileWriter("bookReturnRequest.txt");
                    writer.write(loan.getBookLoan().getTitle() + "," +
                            loan.getBookLoan().getAuthor() + "," +
                            loan.getBookLoan().getYearPublished() + "," +
                            loan.getBookLoan().getPageCount() + "," +
                            loan.getBookLoan().isToExist() + "," +

                            loan.getStudent().getFirstName() + "," +
                            loan.getStudent().getLastName() + "," +
                            loan.getStudent().getMajor() + "," +
                            loan.getStudent().getStudentId() + "," +
                            loan.getStudent().getMemberShipDate() + "," +

                            loan.getGiverManager().getFirstName() + "," +
                            loan.getGiverManager().getLastName() + "," +
                            loan.getGiverManager().getUserId() + "," +

                            loan.getReceiverManager().getFirstName()+"," +
                            loan.getReceiverManager().getLastName()+"," +
                            loan.getReceiverManager().getUserId()+"," +

                            loan.getBorrowDate() + "," +
                            loan.getDueDate() + "," +
                            loan.getActualReturn()+ "," +
                            loan.getLaterTime()+ "," +
                            loan.getTotalLoanCount() + "\n");
                    writer.close();
                    System.out.println("Write bookReturnRequest to file Successful");
                }catch(IOException e){
                    System.out.println("Error: "+e.getMessage());
                }
            }
        }
    }

    @Override
    public String toString() {
        return
                firstName + "," +
                lastName + "," +
                userId + ","
                ;
    }
}
