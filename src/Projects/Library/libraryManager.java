package Projects.Library;

import com.sun.xml.internal.fastinfoset.algorithm.BooleanEncodingAlgorithm;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class libraryManager {
    private String firstName;
    private String lastName;
    private long userId;

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public long getUserId() {
        return userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public libraryManager getRandomManager(Library library){
        Random random = new Random();
        ArrayList<libraryManager> managers = library.getArrayLibraryManagers();
        if (managers.isEmpty()) {
            System.out.println("No managers available.");
            return null;
        }
        return managers.get(random.nextInt(managers.size()));
    }

    public void borrowBook(Library library, Student student, Book book){
        if(!book.isToExist()) {
            System.out.println("is not exist!");
            return;
        }

        libraryManager randomManager= getRandomManager(library);

        BookLoan loan = new BookLoan();
        loan.setBookLoan(book);
        loan.setStudentBookLoan(student);
        loan.setGiverManager(randomManager);
        loan.setReceiverManager(null);
        loan.setBorrowDate(LocalDate.now());
        loan.setDueDate(LocalDate.now().plusDays(20));
        loan.incrementLoanCount();
        loan.setLaterTime(Period.ZERO);
        loan.setActualReturnTemp(Period.ZERO);
        library.addLoan(loan);

        book.setToExist(false);

    }

    public Book toExistBook(String title,String author,Library library){
        boolean found = false;
        for (int i = 0; i < library.getArrayBooks().size(); i++) {
            Book book = library.getArrayBooks().get(i);
            if (
                    (book.getTitle().toLowerCase().contains(title.toLowerCase())) &&
                            (book.getAuthor().toLowerCase().contains(author.toLowerCase())
                            && book.isToExist() == true) ){

                found = true;
                return book;
            }
        }
        return null;
    }
    public Student toExistStudent(Long studentId , Library library) {
        for (int i = 0; i < library.getArrayStudents().size(); i++) {
            Student student = library.getArrayStudents().get(i);
            if (studentId != null && studentId.equals(student.getStudentId())) {
                return student;
            }
        }
        return null;
    }
    public boolean studentRequest(Student student, Book book, List<Request> requestList) {
        for (Request req  : requestList) {
            if (req.getStudent().getStudentId().equals(student.getStudentId()) &&
                    req.getBook().getTitle().equals(book.getTitle())) {
                return true;
            }
        }
        return false;
    }

    public void borrowBookRequest(Library library,libraryManager manager){
        for(int i=0;i<library.getArrayRequest().size();i++){
            Request request = library.getArrayRequest().get(i);
            System.out.println(i+") "+request);
        }
        if(library.getArrayRequest().size()>0) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the student Id: ");
            int Number = input.nextInt();
            Book book = library.getArrayRequest().get(Number).getBook();
            library.getArrayBooks().get(Number).setToExist(false);
            Student student = library.getArrayRequest().get(Number).getStudent();
            library.getArrayRequest().remove(Number);
            BookLoan loan = new BookLoan();
            loan.setBookLoan(book);
            loan.setStudentBookLoan(student);
            loan.setGiverManager(manager);
            loan.setBorrowDate(LocalDate.now());
            loan.setDueDate(LocalDate.now().plusDays(20));
            loan.incrementLoanCount();
            library.addLoan(loan);
            System.out.println("The book was loaned");
        }
        else{
            System.out.println("There is no request!");
        }


    }

    public Book toExistReturnBookRequest(String title , String author , Library library){
        for(int i=0;i<library.getArrayBookLoans().size();i++){
            if(library.getArrayBookLoans().get(i).getBookLoan().getTitle().equalsIgnoreCase(title) &&
                    library.getArrayBookLoans().get(i).getBookLoan().getAuthor().equalsIgnoreCase(author)){
                return library.getArrayBookLoans().get(i).getBookLoan();
            }
        }
        return null;
    }
    public Student toExistReturnBookRequest(Long studentId , Library library){
        for(int i=0;i<library.getArrayBookLoans().size();i++){
            if(library.getArrayBookLoans().get(i).getStudent().getStudentId().equals(studentId)){
                return library.getArrayBookLoans().get(i).getStudent();
            }
        }
        return null;
    }
    public void ReturnBookRequest(Student student , Book book, Library library, libraryManager manager) {
        for(int i=0;i<library.getArrayBookLoans().size();i++){
            if(library.getArrayBookLoans().get(i).getStudent().equals(student)&&library.getArrayBookLoans().get(i).getBookLoan().equals(book) ){
                BookLoan loan = library.getArrayBookLoans().get(i);
                loan.setGiverManager(manager);
                loan.setReceiverManager(manager);
                loan.setActualReturn(LocalDate.now());
                loan.setLaterTime(Period.between(loan.getBorrowDate(),loan.getBorrowDate()));
                try{
                    FileWriter writer = new FileWriter("bookReturnRequest.txt");
                    writer.write(loan.getBookLoan().getTitle() + "," +
                            loan.getBookLoan().getAuthor() + "," +
                            loan.getBookLoan().getYearPublished() + "," +
                            loan.getBookLoan().getPageCount() + "," +
                            loan.getBookLoan().isToExist() + "," +

                            loan.getStudent().getFirstName() + "," +
                            loan.getStudent().getLastName() + "," +
                            loan.getStudent().getMajor() + "," +
                            loan.getStudent().getStudentId() + "," +
                            loan.getStudent().getMemberShipDate() + "," +

                            loan.getGiverManager().getFirstName() + "," +
                            loan.getGiverManager().getLastName() + "," +
                            loan.getGiverManager().getUserId() + "," +

                            loan.getReceiverManager().getFirstName()+"," +
                            loan.getReceiverManager().getLastName()+"," +
                            loan.getReceiverManager().getUserId()+"," +

                            loan.getBorrowDate() + "," +
                            loan.getDueDate() + "," +
                            loan.getActualReturn()+ "," +
                            loan.getLaterTime()+ "," +
                            loan.getTotalLoanCount() + "\n");
                    writer.close();
                    System.out.println("Write bookReturnRequest to file Successful");
                }catch(IOException e){
                    System.out.println("Error: "+e.getMessage());
                }
            }
        }
    }

    public void acceptReturnRequest(Library library, libraryManager manager) {
        File requestFile = new File("bookReturnRequest.txt");
        List<String> remainingRequests = new ArrayList<>();

        try (Scanner scan = new Scanner(new FileReader(requestFile))) {
            boolean foundRequest = false;

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.split(",");

                if (parts.length < 9) {
                    System.out.println("Invalid request format: " + line);
                    continue;
                }

                foundRequest = true;

                Book book = new Book();
                book.setTitle(parts[0]);
                book.setAuthor(parts[1]);
                book.setToExist(Boolean.parseBoolean(parts[4]));

                Student student = new Student();
                student.setStudentId(Long.parseLong(parts[8]));

                boolean matched = false;

                if (book.isToExist()) {
                    for (BookLoan loan : library.getArrayBookLoans()) {
                        if (loan.getBookLoan().getTitle().equalsIgnoreCase(book.getTitle()) &&
                                loan.getBookLoan().getAuthor().equalsIgnoreCase(book.getAuthor()) &&
                                loan.getStudent().getStudentId().equals(student.getStudentId())) {

                            loan.setActualReturn(LocalDate.now());
                            loan.setLaterTime(Period.between(loan.getDueDate(), loan.getActualReturn()));
                            loan.setReceiverManager(manager);
                            loan.getBookLoan().setToExist(false);
                            System.out.println("The request was successfully approved.");
                            matched = true;
                            break;
                        }
                    }
                }

                for(Book book1 : library.getArrayBooks()){
                    if(book1.getTitle().equals(book.getTitle()) && book1.getAuthor().equals(book1.getAuthor())){
                        book1.setToExist(true);
                    }
                }

                if (!matched) {
                    remainingRequests.add(line);
                }
            }

            if (!foundRequest) {
                System.out.println("There is no request.");
            }

            try (PrintWriter writer = new PrintWriter(new FileWriter(requestFile))) {
                for (String remaining : remainingRequests) {
                    writer.println(remaining);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading request file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number from file: " + e.getMessage());
        }
    }
    @Override
    public String toString() {
        return
                firstName + "," +
                lastName + "," +
                userId + ","
                ;
    }
}
