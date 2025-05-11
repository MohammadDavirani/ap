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

    public void addBookToLibrary(Library lib, Book book){
        lib.addBook(book);
    }

    public static void listOfBooksBorrowed(Library library){
        if (library.getArrayBookLoans().isEmpty()) {
            System.out.println("No books have been borrowed.");
            return;
        }
        for(int i=0;i<library.getArrayBookLoans().size();i++){
            bookLoan bookLoan = library.getArrayBookLoans().get(i);
            int daysLater = bookLoan.laterTime.getDays();
            if(daysLater>0){
                System.out.println(bookLoan);
            }
        }
    }



}
