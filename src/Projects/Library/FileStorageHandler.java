package Projects.Library;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class FileStorageHandler {
    public void saveLibraryData(Library library , libraryAdmin admin){

        try{
            FileWriter writer = new FileWriter("Books.txt");
            for(int i=0;i<library.getArrayBooks().size();i++){
                Book book = library.getArrayBooks().get(i);
                writer.write(
                        book.getTitle()+","+
                        book.getAuthor()+","+
                        book.getPageCount()+","+
                        book.getYearPublished()+","+
                        book.isToExist()+"\n"
                );
            }
            System.out.println("Write ArrayBooks to file Successful");
            writer.close();

        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }

        try{
            FileWriter writer = new FileWriter("Student.txt");
            for (int i = 0; i < library.getArrayStudents().size(); i++) {
                Student student = library.getArrayStudents().get(i);
                writer.write(
                        student.getFirstName()+","+
                        student.getLastName()+","+
                        student.getMajor()+","+
                        student.getStudentId()+","+
                        student.getMemberShipDate().toString()+"\n"
                );
            }
            System.out.println("Write ArrayStudents to file Successful");
            writer.close();
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }

        try{
            FileWriter writer = new FileWriter("Managers.txt");
            for(int i=0;i<library.getArrayLibraryManagers().size();i++){
                libraryManager manager = library.getArrayLibraryManagers().get(i);
                writer.write(
                        manager.getFirstName()+","+
                        manager.getLastName()+","+
                        manager.getUserId()+"\n"
                );

            }
            System.out.println("Write ArrayLibraryManagers to file Successful");
            writer.close();
        }catch(IOException e){
            System.out.println("Error: "+ e.getMessage());
        }

        try {
            FileWriter writer = new FileWriter("BookLoans.txt");
            for (BookLoan loan : library.getArrayBookLoans()) {
                writer.write(
                        loan.getBookLoan().getTitle() + "," +
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


                                (loan.getReceiverManager() != null ? loan.getReceiverManager().getFirstName() : "null") + "," +
                                (loan.getReceiverManager() != null ? loan.getReceiverManager().getLastName() : "null") + "," +
                                (loan.getReceiverManager() != null ? loan.getReceiverManager().getUserId() : "null") + "," +

                                loan.getBorrowDate() + "," +
                                loan.getDueDate() + "," +
                                (loan.getActualReturn() != null ? loan.getActualReturn().toString() : "null") + "," +
                                (loan.getLaterTime() != null ? loan.getLaterTime().toString() : "null") + "," +
                                loan.getTotalLoanCount() + "\n"
                );
            }

            writer.close();
            System.out.println("Write ArrayBookLoan to file Successful");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }


        try{
            FileWriter writer = new FileWriter("SizeOfArray.txt");
            writer.write(
                    library.getArrayBooks().size()+"\n"+
                        library.getArrayStudents().size()+"\n"+
                        library.getArrayLibraryManagers().size()+"\n"+
                        library.getArrayBookLoans().size()+"\n"+
                            library.getArrayRequest().size()
            );
            writer.close();
            System.out.println("Write SizeOfAllArray to file Successful");
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }

        try{
            FileWriter writer = new FileWriter("Admin.txt");
            writer.write(
                        admin.getFirstName()+","+
                            admin.getLastName()+","+
                            admin.getEducationLevel()+","+
                            admin.getUserId()
            );
            writer.close();
            System.out.println("Write Admin to file Successful");
        }catch(IOException e)
        {
            System.out.println("Error: "+e.getMessage());
        }

        try{
            FileWriter writer = new FileWriter("bookBorrowRequest.txt");
            for(int i=0;i<library.getArrayRequest().size();i++){
                Request request = library.getArrayRequest().get(i);
                writer.write(
                            request.getDate()+","+
                                request.getBook().getTitle()+","+
                                request.getBook().getAuthor()+","+
                                request.getBook().getPageCount()+","+
                                request.getBook().getYearPublished()+","+
                                request.getBook().isToExist()+","+
                                request.getStudent().getFirstName()+","+
                                request.getStudent().getLastName()+","+
                                request.getStudent().getMajor()+","+
                                request.getStudent().getStudentId()+","+
                                request.getStudent().getMemberShipDate()+"\n"
                        );
            }
            writer.close();
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }

    }

    public void loadLibraryData(Library library,libraryAdmin admin){
        int sizeOfBooksArray = 0,sizeOfStudentArray = 0,sizeOfLibraryManagerArray = 0,sizeOfBookLoansArray = 0,sizeOfRequestBookArray=0;
        try{
            Scanner scan = new Scanner(new FileReader("SizeOfArray.txt"));
            sizeOfBooksArray = scan.nextInt();
            sizeOfStudentArray = scan.nextInt();
            sizeOfLibraryManagerArray = scan.nextInt();
            sizeOfBookLoansArray = scan.nextInt();
            sizeOfRequestBookArray = scan.nextInt();
            scan.close();
            System.out.println("Scanning SizeOfArray File Done.");
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }

        try {
            Scanner scan = new Scanner(new FileReader("Books.txt"));
            for(int i = 0;i<sizeOfBooksArray && scan.hasNextLine();i++){
                String line = scan.nextLine();
                Book book = getBook(line);
                library.addBook(book);
            }
            scan.close();
            System.out.println("Scanning Books File Done.");

        }catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }

        try {
            Scanner scan = new Scanner(new FileReader("Student.txt"));
            for (int i = 0; i < sizeOfStudentArray; i++) {
                String line = scan.nextLine();
                Student student = getStudent(line);
                library.addStudent(student);
            }
            scan.close();
            System.out.println("Scanning Students File Done.");
        }catch (IOException e){
            System.out.println(("Error: "+e.getMessage()));
        }

        try {
            Scanner scan = new Scanner(new FileReader("Managers.txt"));
            for(int i=0;i<sizeOfLibraryManagerArray;i++){
                String line = scan.nextLine();
                libraryManager manager = getManager(line);
                library.addManager(manager);
            }
            scan.close();
            System.out.println("Scanning Managers File Done.");
        }catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }

        try {
            Scanner scan = new Scanner(new FileReader("BookLoans.txt"));
            for (int i = 0; i < sizeOfBookLoansArray; i++) {
                String line = scan.nextLine();
                BookLoan loan = getBookLoan(line);
                library.addLoan(loan);
            }
            scan.close();
            System.out.println("Scanning BookLoans File Done.");
        }catch(IOException e) {
            System.out.println("Error: "+e.getMessage());
        }

        try{
            Scanner scan = new Scanner(new FileReader("Admin.txt"));
            String line = scan.nextLine();
            String[] parts = line.split(",");
            admin.setFirstName(parts[0]);
            admin.setLastName(parts[1]);
            admin.setEducationLevel(parts[2]);
            admin.setUserId(Long.parseLong(parts[3]));
            scan.close();
            System.out.println("Scanning Admin File Done.");

        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }

        try{
            Scanner scan = new Scanner(new FileReader("bookBorrowRequest.txt"));
            for(int i=0;i<sizeOfRequestBookArray;i++){
                String line = scan.nextLine();
                Request request = getBookRequest(line);
                library.addRequest(request);
            }
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    private static Book getBook(String line) {
        String[] parts = line.split(",");

        String title = parts[0],author = parts[1];
        int  pageCount = Integer.parseInt(parts[2]),yearPublished =Integer.parseInt( parts[3]);
        Boolean toExist = Boolean.parseBoolean((parts[4]));
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPageCount(pageCount);
        book.setYearPublished(yearPublished);
        book.setToExist(toExist);
        return book;
    }
    private static Student getStudent(String line){
        Student student =new Student();
        String[] parts = line.split(",");
        String firstName = parts[0],lastName = parts[1],major = parts[2];
        Long stuID = Long.parseLong(parts[3]);
        LocalDate date = LocalDate.parse(parts[4]);

        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setMajor(major);
        student.setStudentId(stuID);
        student.setMemberShipDate(date);

        return student;
    }
    private static libraryManager getManager(String line){
        String[] parts = line.split(",");
        libraryManager manager = new libraryManager();
        String firstName = parts[0],lastName = parts[1];
        Long userId = Long.parseLong(parts[2]);
        manager.setFirstName(firstName);
        manager.setLastName(lastName);
        manager.setUserId(userId);
        return manager;
    }
    private static BookLoan getBookLoan(String line) {
        String[] parts = line.split(",");

        if (parts.length < 21) {
            System.out.println("Invalid BookLoan data: " + line);
            return null;
        }

        BookLoan loan = new BookLoan();

        Book book = new Book();
        book.setTitle(parts[0]);
        book.setAuthor(parts[1]);
        book.setYearPublished(Integer.parseInt(parts[2]));
        book.setPageCount(Integer.parseInt(parts[3]));
        book.setToExist(Boolean.parseBoolean(parts[4]));

        Student student = new Student();
        student.setFirstName(parts[5]);
        student.setLastName(parts[6]);
        student.setMajor(parts[7]);
        student.setStudentId(Long.parseLong(parts[8]));
        student.setMemberShipDate(LocalDate.parse(parts[9]));

        libraryManager giverManager = new libraryManager();
        giverManager.setFirstName(parts[10]);
        giverManager.setLastName(parts[11]);
        giverManager.setUserId(Long.parseLong(parts[12]));

        libraryManager receiverManager = null;
        if (!parts[13].equals("null")) {
            receiverManager = new libraryManager();
            receiverManager.setFirstName(parts[13]);
            receiverManager.setLastName(parts[14]);
            receiverManager.setUserId(Long.parseLong(parts[15]));
        }

        LocalDate borrowDate = LocalDate.parse(parts[16]);
        LocalDate dueDate = LocalDate.parse(parts[17]);

        LocalDate actualReturn = parts[18].equals("null") ? null : LocalDate.parse(parts[18]);

        Period laterTime = parts[19].equals("null") ? null : Period.parse(parts[19]);

        int totalLoanCount = Integer.parseInt(parts[20]);

        loan.setBookLoan(book);
        loan.setStudentBookLoan(student);
        loan.setGiverManager(giverManager);
        loan.setReceiverManager(receiverManager);
        loan.setBorrowDate(borrowDate);
        loan.setDueDate(dueDate);
        loan.setActualReturn(actualReturn);
        loan.setLaterTime(laterTime);
        loan.setCountLoan(totalLoanCount);

        return loan;
    }
    private static Request getBookRequest(String line){
        String[] parts = line.split(",");
        Request request =new Request();
        request.setDate(LocalDate.parse(parts[0]));
        Book book = new Book();
        book.setTitle(parts[1]);
        book.setAuthor(parts[2]);
        book.setPageCount(Integer.parseInt(parts[3]));
        book.setYearPublished(Integer.parseInt(parts[4]));
        book.setToExist(Boolean.parseBoolean(parts[5]));
        request.setBook(book);

        Student student =new Student();
        student.setFirstName(parts[6]);
        student.setLastName(parts[7]);
        student.setMajor(parts[8]);
        student.setStudentId(Long.parseLong(parts[9]));
        student.setMemberShipDate(LocalDate.parse(parts[10]));
        request.setStudent(student);

        return request;
    }
}
