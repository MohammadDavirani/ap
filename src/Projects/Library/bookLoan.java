package Projects.Library;

public class bookLoan {
    Book bookLoan;
    Student student;
    LibraryManager giverManager;
    LibraryManager receiverManager;

    int loanMonth,loanDay;
    int returnMonth,returnDay;
    int actualReturnMonth , actualReturnDay;

    public void setBookLoan(Book bookLoan) {
        this.bookLoan = bookLoan;
    }
    public void setStudentBookLoan(Student student) {
        this.student = student;
    }
    public void setGiverManager(LibraryManager giverManager) {
        this.giverManager = giverManager;
    }
    public void setReceiverManager(LibraryManager receiverManager) {
        this.receiverManager = receiverManager;
    }
    public void setLoanDate(int Month,int day) {
        this.loanMonth = Month;
        this.loanDay = day;
    }
    public void setExpectedReturnDate(int Month,int day) {
        this.returnMonth = Month;
        this.returnDay = day;
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
                ", loanMonth=" + loanMonth +
                ", loanDay=" + loanDay +
                ", returnMonth=" + returnMonth +
                ", returnDay=" + returnDay +
                ", actualReturnMonth=" + actualReturnMonth +
                ", actualReturnDay=" + actualReturnDay +
                '}';
    }
}
