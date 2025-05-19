package Projects.Library;

import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    private String libraryName;

    public Library(String libraryName) {
        this.libraryName = libraryName;
    }

    public Library() {

    }

    ArrayList<Book> ArrayBooks = new ArrayList<>();
    ArrayList<Student> ArrayStudents = new ArrayList<>();
    ArrayList<libraryManager> ArrayLibraryManagers = new ArrayList<>();
    ArrayList<BookLoan> ArrayBookLoans = new ArrayList<>();
    public BookLoan[] mostBooksLoans;

    ArrayList<Request> ArrayRequest = new ArrayList<>();
    public void addRequest(Request request){
        ArrayRequest.add(request);
    }
    public ArrayList<Request> getArrayRequest() {
        return ArrayRequest;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }
    public void addBook(Book book) {
        this.ArrayBooks.add(book);
    }
    public void addStudent(Student student) {
        this.ArrayStudents.add(student);
    }
    public void addManager(libraryManager manager) {
        this.ArrayLibraryManagers.add(manager);
    }
    public void addLoan(BookLoan bookloan) {
        this.ArrayBookLoans.add(bookloan);
    }

    public ArrayList<Book> getArrayBooks() {
        return ArrayBooks;
    }
    public ArrayList<Student> getArrayStudents() {
        return ArrayStudents;
    }
    public ArrayList<libraryManager> getArrayLibraryManagers() {
        return ArrayLibraryManagers;
    }
    public ArrayList<BookLoan> getArrayBookLoans() {
        return ArrayBookLoans;
    }

    public void searchBook(String title, String author) {
        boolean found = false;
        for (int i = 0; i < ArrayBooks.size(); i++) {
            Book book = ArrayBooks.get(i);
            if (
                    (book.getTitle().toLowerCase().contains(title.toLowerCase())) &&
                    (book.getAuthor().toLowerCase().contains(author.toLowerCase()) && book.isToExist())
            ) {
                System.out.println("Book found:");
                System.out.println(book);
                found = true;

            }
        }
        if (!found) {
            System.out.println("Book not found in library.");
        }
    }

    public void countBooksLoans(){
        ArrayList<libraryManager> managers = new ArrayList<>();
        ArrayList<Integer> managerLoanCounts = new ArrayList<>();

        for (int i = 0; i < getArrayBookLoans().size(); i++) {
            BookLoan loan = getArrayBookLoans().get(i);
            libraryManager manager = loan.getGiverManager();
            if(managers.contains(manager)){
                int index = managers.indexOf(manager);
                managerLoanCounts.set(index, managerLoanCounts.get(index) + 1);
            }
            else{
                managers.add(manager);
                managerLoanCounts.add(1);
            }
        }
        for (int i = 0; i < managers.size(); i++) {
            libraryManager manager = managers.get(i);
            int count = managerLoanCounts.get(i);
            System.out.println("Manager: " + manager.getFirstName() + " " + manager.getLastName() +
                    " (ID: " + manager.getUserId() + ") -> Loans count: " + count);
        }


    }

    public void top10BooksLastYear() {
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();

        LocalDate oneYearAgo = LocalDate.now().minusYears(1);

        for (int i = 0; i < getArrayBookLoans().size(); i++) {
            BookLoan loan = getArrayBookLoans().get(i);
            if (loan.getBorrowDate().isAfter(oneYearAgo)) {
                Book book = loan.getBookLoan();
                boolean found = false;
                for (int j = 0; j < books.size(); j++) {
                    if (books.get(j).equals(book)) {
                        counts.set(j, counts.get(j) + 1);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    books.add(book);
                    counts.add(1);
                }
            }
        }

        for (int i = 0; i < counts.size() - 1; i++) {
            for (int j = i + 1; j < counts.size(); j++) {
                if (counts.get(j) > counts.get(i)) {
                    int tempCount = counts.get(i);
                    counts.set(i, counts.get(j));
                    counts.set(j, tempCount);

                    Book tempBook = books.get(i);
                    books.set(i, books.get(j));
                    books.set(j, tempBook);
                }
            }
        }

        int limit = Math.min(10, books.size());
        for (int i = 0; i < limit; i++) {
            System.out.println((i + 1) + ". " + books.get(i).getTitle() + " - Borrowed " + counts.get(i) + " times");
        }
    }


}
