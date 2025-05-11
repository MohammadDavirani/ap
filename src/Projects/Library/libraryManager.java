package Projects.Library;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Random;

public class libraryManager {
    private String firstName;
    private String lastName;
    private int userId;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void searchingBook(){

    }

    public void BookDelivery(){

    }

    public static libraryManager getRandomManager(){
        Library library = new Library();
        Random random = new Random();
        ArrayList<libraryManager> managers = library.getArrayLibraryManagers();
        libraryManager randomManager = managers.get(random.nextInt(managers.size()));
        return randomManager;
    }
    public void borrowBook(Library library, Student student, Book book){
        if(!book.isToExist()) {
            System.out.println("is not exist!");
            return;
        }

        libraryManager randomManager= libraryManager.getRandomManager();

        bookLoan loan = new bookLoan();
        loan.setBookLoan(book);
        loan.setStudentBookLoan(student);
        loan.setGiverManager(randomManager);
        loan.setBorrowDate(LocalDate.now());
        loan.setDueDate(LocalDate.now().plusDays(20));

        library.addLoan(loan);

        book.setToExist(false);

    }
    public void returnBook(Library library , Student student, Book book){
        libraryManager randomManager= libraryManager.getRandomManager();

        for(int i=0;i< library.getArrayBookLoans().size();i++){
            bookLoan loan = library.getArrayBookLoans().get(i);

            if (loan.getBookLoan().equals(book) && loan.getStudent().equals(student)) {
                loan.getBookLoan().setToExist(true);
                loan.setReceiverManager(randomManager);
                loan.setActualReturn(LocalDate.now());
                Period period = Period.between(loan.getDueDate(),loan.getActualReturn());
                loan.setLaterTime(period);
                System.out.println("Book returned successfully.");
                return;
            }
            else{
                System.out.println("No matching loan record found.");
            }
        }
    }

}
