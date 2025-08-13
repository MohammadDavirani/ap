package Projects.finalproject;

import java.io.Serializable;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class LibrarySystem implements Serializable {
    private StudentManager studentManager;
    private AdminManager adminManager;
    private MenuHandler menuHandler;
    private BookManager bookManager;
    private Scanner scanner;
    //--------------------------------------------------------------------
    public LibrarySystem() {
        this.studentManager = new StudentManager();
        this.adminManager = new AdminManager();
        this.bookManager = new BookManager();
        this.menuHandler = new MenuHandler(this);
        this.scanner = new Scanner(System.in);
    }


    public List<Student> getStudents(){
        return this.studentManager.getStudents();
    }
    public List<BooksRequested> getRequests(){
        return this.studentManager.getBooksRequested();
    }
    public List<Admin> getAdmins(){
        return this.adminManager.getAdmins();
    }
    public List<Book> getBooks(){
        return this.bookManager.getBooks();
    }
    public int getStudentCount() {
        return this.studentManager.getStudentCount();
    }

    public void setBookRequests(List<BooksRequested> bookRequests){
        this.studentManager.setBooksRequested(bookRequests);
    }
    public void setStudent(List<Student> students){
        this.studentManager.setStudents(students);
    }
    public void setAdmin(List<Admin> admins){
        this.adminManager.setAdmins(admins);
    }
    public void setBook(List<Book> books){
        this.bookManager.setBooks(books);
    }

    //--------------------------------------------------------------------
    public void registerStudent(String name, String studentId, String username, String password, boolean borrowRequest,boolean activeRequest,boolean active,boolean returnRequest) {
        studentManager.registerStudent(name, studentId, username, password, borrowRequest,activeRequest,active,returnRequest);
    }
    public void registerAdmin(String username, String password){
        adminManager.registerAdmin(username, password);
    }
    public Student authenticateStudent(String username, String password) {
        return studentManager.authenticateStudent(username, password);
    }
    public Admin authenticateAdmin(String username, String password){
        return adminManager.authenticateAdmin(username, password);
    }
    public void addBook(Admin currentAdminUser){
        currentAdminUser.setNumberOfBooksRegistered(currentAdminUser.getNumberOfBooksRegistered()+1);
        String title,author,yearOfPublishing;
        boolean exist = true;
        System.out.println("enter title:");
        title = scanner.nextLine();
        System.out.println("enter author:");
        author = scanner.nextLine();
        System.out.println("enter year of publishing:");
        yearOfPublishing = scanner.nextLine();

        bookManager.addBook(author,title,yearOfPublishing,exist);
    }
    public void editStudentInformation(Student student) {
        System.out.println("== Editing box ==");
        System.out.println("1. edit name");
        System.out.println("2. edit id");
        System.out.println("3. edit username");
        System.out.println("4. edit password");
        System.out.println("5.Exit");
        System.out.print("Please enter your choice: ");
        int choice = menuHandler.getIntInput(1, 5);
        String newName,newId,newUsername,newPassword;

        switch(choice){
            case 1:
                System.out.println("enter new name:");
                newName = scanner.nextLine();
                student.setName(newName);
                System.out.println("Student information editing successfully.");
                break;

            case 2:
                System.out.println("enter new Id:");
                newId = scanner.nextLine();
                student.setStudentId(newId);
                System.out.println("Student information editing successfully.");
                break;

            case 3:
                System.out.println("enter new Username:");
                newUsername = scanner.nextLine();
                student.setUsername(newUsername);
                System.out.println("Student information editing successfully.");
                break;

            case 4:
                System.out.println("enter new Password:");
                newPassword = scanner.nextLine();
                student.setPassword(newPassword);
                System.out.println("Student information editing successfully.");
                break;

            case 5:
                System.out.println("Exiting from editing information");
                break;

            default:
                System.out.println("Invalid option! Please try again.");
        }
    }
    public void borrowBook(Student student) {
        if(student.isActive()){
            if(!student.isBorrowRequest()){
                Book requestBook = searchingBook();
                if(requestBook == null){
                    System.out.println("Book not found.");
                }else{
                    if(requestBook.getExist()){
                        System.out.println("book is available");
                        System.out.println("Do you want to register your request?(yes/no)");
                        String question = scanner.nextLine();
                        if(question.equalsIgnoreCase("yes")){
                            student.setBorrowRequest(true);
                            BooksRequested requested = new BooksRequested(student,requestBook);
                            studentManager.addToRequestList(requested);
                            System.out.println("The request was successfully submitted. ");
                        }else{
                            System.out.println("exit from request");
                        }
                    }
                    else{
                        System.out.println("this book is not available");
                    }
                }

            }else{
                System.out.println("Book request registration is active for you.");
            }
        }
        else{
            System.out.println("Your account is inactive.");
        }
    }
    public void returnBook(Student student) {
        if(student.isActive()){
            if(!student.isReturnRequest()){
                System.out.println("Enter the title of the book you want to return: ");
                String title = scanner.nextLine();
                Book book = student.getLoanBooks().stream()
                        .filter(s->s.getTitle().equalsIgnoreCase(title))
                        .findFirst()
                        .orElse(null);

                if(book!=null){
                    ReturnBooksRequested returnBooksRequested = new ReturnBooksRequested(student,book);
                    studentManager.addToReturnRequestList(returnBooksRequested);
                    student.setReturnRequest(true);
                    System.out.println("The request was successfully submitted. ");
                }
                else{
                    System.out.println("No book with this name was found.");
                }
            }
            else{
                System.out.println("Book return registration is active for you.");
            }
        }
        else{
            System.out.println("Your account is inactive.");
        }
    }
    public void displayAvailableBooks() {
        bookManager.getBooks().stream().
                filter(Book::getExist).
                forEach(System.out::println);
    }
    public void start() {
        menuHandler.displayMainMenu();
    }

    public Book searchingBook(){
        System.out.println("== searching book box ==");
        System.out.println("1.search by title and author");
        System.out.println("2.search by title and year Of publishing");
        System.out.println("3.search by author and year of publishing");
        System.out.println("4.Exit");
        System.out.print("Please enter your choice: ");
        int choice = menuHandler.getIntInput(1, 4);

        String title,author,yearOfPublishing;

        switch(choice){
            case 1:
                System.out.println("enter title:");
                title = scanner.nextLine();

                System.out.println("enter author:");
                author = scanner.nextLine();

                return bookManager.getBooks().stream()
                        .filter(s -> s.getTitle().equalsIgnoreCase(title.trim()) && s.getAuthor().equalsIgnoreCase(author.trim()))
                        .findFirst()
                        .orElse(null);

            case 2:
                System.out.println("enter title");
                title = scanner.nextLine();

                System.out.println("enter year Of Publishing:");
                yearOfPublishing = scanner.nextLine();

                return bookManager.getBooks().stream()
                        .filter(s -> s.getTitle().equalsIgnoreCase(title.trim()) && s.getYearOfPublishing().equalsIgnoreCase(yearOfPublishing.trim()))
                        .findFirst()
                        .orElse(null);

            case 3:
                System.out.println("enter year Of Publishing:");
                yearOfPublishing = scanner.nextLine();

                System.out.println("enter author:");
                author = scanner.nextLine();

                return bookManager.getBooks().stream()
                        .filter(s -> s.getAuthor().equalsIgnoreCase(author.trim()) && s.getYearOfPublishing().equalsIgnoreCase(yearOfPublishing.trim()))
                        .findFirst()
                        .orElse(null);

            case 4:
                System.out.println("exiting");
                break;


            default:
                System.out.println("Invalid option! Please try again.");
        }
        return null;
    }
    public Book searchWithTitle(){
        System.out.println("Enter Title:");
        String title = scanner.nextLine();
        return bookManager.getBooks().stream()
                .filter(s->s.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }
    public void editBookInformation(){
        Book editBook = searchingBook();
        System.out.println("=== Edit Book Information Box ===");
        System.out.println("1. edit title");
        System.out.println("2. edit author");
        System.out.println("3. edit year of publishing");
        System.out.println("4. Exit");
        System.out.print("Please enter your choice: ");

        int choice = menuHandler.getIntInput(1, 4);
        switch(choice){
            case 1:
                System.out.println("enter new title: ");
                editBook.setTitle(scanner.nextLine());
                System.out.println("Book information editing successfully.");
                break;

            case 2:
                System.out.println("enter new author: ");
                editBook.setAuthor(scanner.nextLine());
                System.out.println("Book information editing successfully.");
                break;

            case 3:
                System.out.println("enter new year of publishing: ");
                editBook.setYearOfPublishing(scanner.nextLine());
                System.out.println("Book information editing successfully.");
                break;

            case 4:
                System.out.println("Exiting");
                break;

            default:
                System.out.println("Invalid option! Please try again.");
        }
    }
    public void checkingRequest(Admin currentAdminUser) {
        List<BooksRequested> list = studentManager.getBooksRequested().stream()
                .filter(s -> s.getStudent().isBorrowRequest())
                .collect(Collectors.toList());

        if (list.isEmpty()) {
            System.out.println("No borrow requests found.");
            return;
        }

        for(BooksRequested requested : list){
            System.out.println(requested);
        }

        String question;
        do {
            System.out.print("Enter student id: ");
            String studentId = scanner.nextLine();

            BooksRequested requested = list.stream()
                    .filter(s -> s.getStudent().getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElse(null);

            if (requested != null) {
                System.out.print("Can the request be approved? (yes/no): ");
                String request = scanner.nextLine();

                if (request.equalsIgnoreCase("yes")) {
                    if (requested.getBook().getExist()) {
                        requested.getBook().setExist(false);
                        requested.getStudent().setBorrowRequest(false);
                        currentAdminUser.setNumberOfBooksLoaned(currentAdminUser.getNumberOfBooksLoaned() + 1);
                        requested.getStudent().setActiveRequests(true);
                        System.out.println("Done successfully");
                        ActiveRequest activeRequest = new ActiveRequest(requested.getStudent(),requested.getBook());
                        List<ActiveRequest> activeRequests = studentManager.getActiveRequests();
                        activeRequests.add(activeRequest);
                        studentManager.removeRequest(requested);
                    } else {
                        System.out.println("Book is not available!");
                    }
                } else {
                    requested.getStudent().setBorrowRequest(false);
                    System.out.println("Request not approved.");
                }
            } else {
                System.out.println("ID not found!");
            }

            System.out.println("Press 'q' to exit or any other key to continue: ");
            question = scanner.nextLine();
        } while (!"q".equalsIgnoreCase(question));
    }
    public void informationMode(){
        System.out.println("=== information mode ===");
        System.out.println("1. all student count");
        System.out.println("2. all book count");
        System.out.println("3. all borrow book count");
        System.out.println("4. all new borrow book count");
        System.out.println("5.Exit");

        System.out.print("Please enter your choice: ");
        int choice = menuHandler.getIntInput(1, 5);

        switch(choice){
            case 1:
                System.out.println("all student count : " + getStudentCount());
                break;

            case 2:
                System.out.println("all book count : " + getBooks().size());
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                System.out.println("Exiting");
                break;

            default:
                System.out.println("Invalid option! Please try again.");
        }
    }


    public void activeRequests(Student student){
        if(student.isActiveRequests()){
            ActiveRequest request = studentManager.getActiveRequests().stream()
                    .filter(s -> s.getStudent().getStudentId().equalsIgnoreCase(student.getStudentId()))
                    .findFirst()
                    .orElse(null);

            if (request != null) {
                Book book = request.getBook();
                LocalDate startDate = LocalDate.now();
                LocalDate endDate = startDate.plusDays(20);

                student.addLoan(book, startDate, endDate);

                System.out.println("The book with the specifications: "+book+" was activated \nfrom date "+startDate+" to date "+endDate+" \nfor student Id: "+student.getStudentId());
                student.setActiveRequests(false);
                studentManager.getActiveRequests().remove(request);

            } else {
                System.out.println("No matching active request found.");
            }
        }else{
            System.out.println("There is no active request for you.");
        }
    }
    public void studentLoanHistoryInfo(){
        while(true){
            System.out.println("Enter Student Id:");
            String id = scanner.nextLine();

            Student student = studentManager.getStudents().stream()
                    .filter(s->s.getStudentId().equalsIgnoreCase(id))
                    .findFirst()
                    .orElse(null);

            if(student!=null){
                System.out.println("=== View Student Loan History Information Box ===");
                System.out.println("1. loan history");
                System.out.println("2. Total number of loan");
                System.out.println("3. Total number of undelivered books");
                System.out.println("4. Total number of overdue books returned");
                System.out.println("5. Exit");
                System.out.print("Please enter your choice: ");

                int choice = menuHandler.getIntInput(1, 8);
                int totalBookLoan = student.getLoanBooks().size();
                switch(choice){
                    case 1:
                        for(int i=0;i<totalBookLoan;i++){
                            System.out.format("%d.",i+1);
                            System.out.println(student.getLoanBooks().get(i));
                            System.out.print("Borrow date: "+student.getBorrowDate().get(i) + "return date: " + student.getReturnDate().get(i));
                        }
                        break;

                    case 2:
                        System.out.println("total number of loan books is : "+ totalBookLoan);
                        break;

                    case 3:
                        int totalUndeliveredBook = 0;
                        int size = Math.min(student.getLoanBooks().size(), student.getBorrowDate().size());

                        for (int i = 0; i < size; i++) {
                            Book book = student.getLoanBooks().get(i);
                            LocalDate borrowDate = student.getBorrowDate().get(i);

                            long daysBetween = ChronoUnit.DAYS.between(borrowDate, LocalDate.now());

                            if (daysBetween > 20) {
                                System.out.println(book + " - Borrowed " + daysBetween + " days ago");
                                totalUndeliveredBook++;
                            }
                        }

                        System.out.println("Total undelivered books: " + totalUndeliveredBook);
                        break;

                    case 4:
                        break;

                    case 5:
                        System.out.println("Exiting.");
                        return;

                    default:
                        System.out.println("Invalid option! Please try again.");
                }
            }
            else{
                System.out.println("Student with this id not found. Please try again");
            }
        }
    }
    public void activeAndDeactivateStudent(){
        System.out.println("Enter Student id: ");
        String studentId = scanner.nextLine();

        Student student = studentManager.getStudents().stream()
                .filter(s->s.getStudentId().equalsIgnoreCase(studentId))
                .findFirst()
                .orElse(null);

        if(student != null){
            System.out.println("1. Activating");
            System.out.println("2. Deactivating");
            System.out.println("3.Exit");
            System.out.print("Please enter your choice: ");
            int choice = menuHandler.getIntInput(1, 3);
            switch(choice){
                case 1:
                    student.setActive(true);
                    System.out.println("Activated");
                    break;
                case 2:
                    student.setActive(false);
                    System.out.println("Deactivated");
                    break;
                case 3:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }else{
            System.out.println("incorrect student id. Please try again");
        }
    }

    public void receivingBooks(Admin currentAdminUser){
        while (true) {
            List<ReturnBooksRequested> list = studentManager.getReturnBooksRequested().stream()
                    .filter(s -> !s.getBook().getExist())
                    .collect(Collectors.toList());

            if (list.isEmpty()) {
                System.out.println("No Return requests found.");
                return;
            }

            System.out.println("\n--- Return Requests ---");
            for (ReturnBooksRequested requested : list) {
                System.out.println(requested);
            }

            System.out.print("\nEnter student id: ");
            String studentId = scanner.nextLine().trim();

            ReturnBooksRequested requested = list.stream()
                    .filter(s -> s.getStudent().getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElse(null);

            if (requested == null) {
                System.out.println("Student ID not found in return requests.");
            } else {
                LocalDate returnDate = LocalDate.now();
                int bookIndex = requested.getStudent().getLoanBooks().indexOf(requested.getBook());
                if (bookIndex != -1) {
                    requested.getStudent().getReturnDate().set(bookIndex, returnDate);
                }

                requested.getBook().setExist(true);
                requested.getStudent().setReturnRequest(false);

                currentAdminUser.setNumberOfBooksReceived(
                        currentAdminUser.getNumberOfBooksReceived() + 1
                );

                studentManager.removeReturnRequest(requested);
                System.out.println("Book returned successfully on " + returnDate);
            }

            System.out.print("\nPress 'q' to exit or any other key to continue: ");
            String choice = scanner.nextLine().trim();
            if ("q".equalsIgnoreCase(choice)) {
                break;
            }
        }
    }
    //--------------------------------------------------------------------
    public static void main(String[] args) {
        dataFile file = new dataFile();
        LibrarySystem system = new LibrarySystem();
        file.loadLibraryDataFromFile(system);
        system.start();
        file.saveLibraryDataToFile(system);
    }
}
