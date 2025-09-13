package Projects.finalproject;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String studentId;
    private boolean borrowRequest;
    private boolean returnRequest;
    private boolean activeRequests;
    private List<Book> loanBooks;
    private List<LocalDate> borrowDate;
    private List<LocalDate> returnDate;
    private boolean active;

    public Student(String name, String studentId, String username, String password ,boolean borrowRequest, boolean activeReq,boolean active,boolean returnRequest) {
        super(username,password);
        this.name = name;
        this.studentId = studentId;
        this.borrowRequest = borrowRequest;
        this.activeRequests = activeReq;
        this.loanBooks = new ArrayList<>();
        this.borrowDate = new ArrayList<>();
        this.returnDate = new ArrayList<>();
        this.active = active;
        this.returnRequest = returnRequest;
    }

    public boolean isReturnRequest() {
        return returnRequest;
    }
    public boolean isActive() {
        return active;
    }
    public List<LocalDate> getBorrowDate() {
        return borrowDate;
    }
    public List<LocalDate> getReturnDate() {
        return returnDate;
    }
    public List<Book> getLoanBooks() {
        return loanBooks;
    }
    public String getName() {
        return name;
    }
    public String getStudentId() {
        return studentId;
    }
    public String getUsername() {
        return super.getUsername();
    }
    public String getPassword() {
        return super.getPassword();
    }
    public boolean isBorrowRequest() {
        return borrowRequest;
    }
    public boolean isActiveRequests() {
        return activeRequests;
    }

    public void setReturnRequest(boolean returnRequest) {
        this.returnRequest = returnRequest;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public void setReturnDate(List<LocalDate> returnDate) {
        this.returnDate = returnDate;
    }
    public void setBorrowDate(List<LocalDate> borrowDate) {
        this.borrowDate = borrowDate;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLoanBooks(List<Book> loanBooks) {
        this.loanBooks = loanBooks;
    }
    public void setActiveRequests(boolean activeRequests) {
        this.activeRequests = activeRequests;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public void setUsername(String username) {
        super.setUsername(username);
    }
    public void setPassword(String password) {
        super.setPassword(password);
    }
    public void setBorrowRequest(boolean borrowRequest) {
        this.borrowRequest = borrowRequest;
    }

    public void addLoan(Book book, LocalDate borrowDate, LocalDate returnDate) {
        this.loanBooks.add(book);
        this.borrowDate.add(borrowDate);
        this.returnDate.add(returnDate);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentId='" + studentId + '\'' +
                ", username='" + super.getUsername() + '\'' +
                ", password='" + super.getPassword() + '\'' +
                ", borrowRequest=" + borrowRequest +
                ", returnRequest=" + returnRequest +
                ", activeRequests=" + activeRequests +
                ", loanBooks=" + loanBooks +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", active=" + active +
                '}';
    }
}
