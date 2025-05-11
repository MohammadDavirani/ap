package Projects.Library;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class bookLoan {
    Book bookLoan;
    Student student;
    libraryManager giverManager;
    libraryManager receiverManager;

    LocalDate BorrowDate;

    LocalDate DueDate;
    LocalDate actualReturn;
    Period laterTime;
    private int countBookLoan=0;

    public int getCountBookLoan() {
        return countBookLoan;
    }
    public void setCountBookLoan(int countBookLoan) {
        this.countBookLoan = countBookLoan;
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
