package Projects.Library;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Random;

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
        loan.setBorrowDate(LocalDate.now());
        loan.setDueDate(LocalDate.now().plusDays(20));
        loan.incrementLoanCount();

        library.addLoan(loan);

        book.setToExist(false);

    }
    public void returnBook(Library library , Student student, Book book)    {
        libraryManager randomManager= getRandomManager(library);

        for(int i=0;i< library.getArrayBookLoans().size();i++){
            BookLoan loan = library.getArrayBookLoans().get(i);

            if (loan.getBookLoan().equals(book) && loan.getStudent().equals(student)) {
                loan.getBookLoan().setToExist(true);
                loan.setReceiverManager(randomManager);
                loan.setActualReturn(LocalDate.now());
                Period period = Period.between(loan.getDueDate(),loan.getActualReturn());
                loan.setLaterTime(period);
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("No matching loan record found.");
    }


    @Override
    public String toString() {
        return "libraryManager{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userId=" + userId +
                '}';
    }
}
