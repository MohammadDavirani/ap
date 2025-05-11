package Projects.Library;

import java.time.LocalDate;
import java.util.ArrayList;

public class bookLoan {
    Book bookLoan;
    Student student;
    libraryManager giverManager;
    libraryManager receiverManager;

    LocalDate BorrowDate;
    LocalDate DueDate;
    int actualReturnMonth , actualReturnDay;

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

    public int getActualReturnMonth() {
        return actualReturnMonth;
    }

    public int getActualReturnDay() {
        return actualReturnDay;
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
    public void setActualReturnMonth(int Month,int day) {
        this.actualReturnMonth = Month;
        this.actualReturnDay = day;
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
                ", actualReturnMonth=" + actualReturnMonth +
                ", actualReturnDay=" + actualReturnDay +
                '}';
    }
}
