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

    public BookLoan() {

    }

    public BookLoan(String line) {
        // bookData | studentData | giverManagerData | receiverManagerData | borrowDate | dueDate | actualReturn
        String[] parts = line.split(";");
        this.bookLoan = new Book(parts[0].trim());
        this.student = new Student(parts[1].trim());
        this.giverManager = new libraryManager(parts[2].trim());
        this.receiverManager = new libraryManager(parts[3].trim());
        setBorrowDate(LocalDate.parse(parts[4]));
        setDueDate(LocalDate.parse(parts[5]));
        this.actualReturn = parts[6].equals("null") ? null : LocalDate.parse(parts[6]);

        if (actualReturn != null) {
            this.actualReturnTemp = Period.between(getDueDate(), actualReturn);
            this.laterTime = actualReturn.isAfter(getDueDate()) ? Period.between(getDueDate(), actualReturn) : Period.ZERO;
        }
    }

    public BookLoan(Book book1, Student student1, libraryManager manager1, libraryManager manager2, LocalDate localDate, LocalDate localDate1, Object o) {
        this.bookLoan = book1;
        this.student = student1;
        this.giverManager = manager1;
        this.receiverManager = manager2;
        this.BorrowDate = localDate;
        this.DueDate =localDate1;
    }

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
