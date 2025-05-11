package Projects.Library;

public class libraryAdmin {
    private String firstName;
    private String lastName;
    private String educationLevel;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public static void getOverdueLoans() {

    }
    public static void getLoanStatsPerManager() {

    }
    public static void getTop10LoanedBooks() {

    }

    public void addBookToLibrary(library lib, Book book){
        lib.addBook(book);
    }
}
