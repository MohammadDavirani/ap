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

    public void listOfBooksBorrowed(Library library){
        if (library.getArrayBookLoans().isEmpty()) {
            System.out.println("No books have been borrowed.");
            return;
        }
        for(int i=0;i<library.getArrayBookLoans().size();i++){
            bookLoan loan = library.getArrayBookLoans().get(i);
            int daysLater = loan.laterTime.getDays();
            int monthLater = loan.laterTime.getMonths();
            int yearLater = loan.laterTime.getYears();
            boolean temp = false;
            if(daysLater>0 || monthLater>0 || yearLater >0){
                System.out.println("Book: " + loan.getBookLoan().getTitle());
                System.out.println("Borrowed by: " + loan.getStudent().getFirstName() + " " + loan.getStudent().getLastName());
                System.out.println("Due Date: " + loan.getDueDate());
                System.out.println("Actual Return: " + loan.getActualReturn());
                System.out.println("Days Late: " + loan.laterTime.getDays() + " days\n");
                temp =true;
            }

            if(!temp){
                System.out.println("No overdue books found.");
            }
        }
    }


    @Override
    public String toString() {
        return "libraryAdmin{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", educationLevel='" + educationLevel + '\'' +
                '}';
    }
}
