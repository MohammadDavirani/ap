package Projects.Library;

import java.time.LocalDate;
import java.time.Period;

public class BookLoan {
    Book bookLoan;
    Student student;
    libraryManager giverManager;
    libraryManager receiverManager;

    LocalDate BorrowDate;

    LocalDate DueDate;
    LocalDate actualReturn;
    Period actualReturnTemp;
    Period laterTime;
    private int totalLoanCount =0;

    public Period getActualReturnTemp() {
        return actualReturnTemp;
    }

    public void setActualReturnTemp(Period actualReturnTemp) {
        this.actualReturnTemp = actualReturnTemp;
    }

    public void setCountLoan(int count) {
        this.totalLoanCount = count;
    }
    public int getTotalLoanCount() {
        return totalLoanCount;
    }
    public void incrementLoanCount() {
        this.totalLoanCount++;
    }

    public Period getLaterTime() {
        return laterTime;
    }
    public void setLaterTime(Period laterTime) {
        this.laterTime = laterTime;
    }

    public Book getBookLoan() {
        return bookLoan;
    }
    public Student getStudent() {
        return student;
    }
    public libraryManager getGiverManager() {
        return giverManager;
    }
    public libraryManager getReceiverManager() {
        return receiverManager;
    }
    public LocalDate getBorrowDate() {
        return BorrowDate;
    }
    public LocalDate getDueDate() {
        return DueDate;
    }
    public LocalDate getActualReturn() {
        return actualReturn;
    }

    public void setBookLoan(Book bookLoan) {
        this.bookLoan = bookLoan;
    }
    public void setStudentBookLoan(Student student) {
        this.student = student;
    }
    public void setGiverManager(libraryManager giverManager) {
        this.giverManager = giverManager;
    }
    public void setReceiverManager(libraryManager receiverManager) {
        this.receiverManager = receiverManager;
    }
    public void setBorrowDate(LocalDate date) {
        this.BorrowDate = date;
    }
    public void setDueDate(LocalDate date) {
        this.DueDate = date;
    }
    public void setActualReturn(LocalDate actual) {
        this.actualReturn = actual;
    }

    @Override
    public String toString() {
        return "bookLoan{" +
                "bookLoan=" + bookLoan +
                ", student=" + student +
                ", giverManager=" + giverManager +
                ", receiverManager=" + receiverManager +
                ", BorrowDate=" + BorrowDate +
                ", DueDate=" + DueDate +
                ", actualReturn=" + actualReturn +
                '}';
    }
}
