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

        try{
            FileWriter writer = new FileWriter("BookLoans.txt");
            for(int i=0;i<library.getArrayBookLoans().size();i++){
                BookLoan loan = library.getArrayBookLoans().get(i);
                writer.write(
                        loan.getBookLoan().getTitle()+","+
                        loan.getBookLoan().getAuthor()+","+
                        loan.getBookLoan().getYearPublished()+","+
                        loan.getBookLoan().getPageCount()+","+
                        loan.getBookLoan().isToExist()+","+
                        loan.getStudent().getFirstName()+","+
                        loan.getStudent().getLastName()+","+
                        loan.getStudent().getMajor()+","+
                        loan.getStudent().getStudentId()+","+
                        loan.getGiverManager().getFirstName()+","+
                        loan.getGiverManager().getLastName()+","+
                        loan.getGiverManager().getUserId()+","+
                        loan.getReceiverManager().getFirstName()+","+
                        loan.getReceiverManager().getLastName()+","+
                        loan.getReceiverManager().getUserId()+","+
                        loan.getBorrowDate()+","+
                        loan.getDueDate()+","+
                        loan.getActualReturn()+","+
                        loan.getLaterTime().toString()+","+
                        loan.getTotalLoanCount()+"\n"
                );
            }
            writer.close();
            System.out.println("Write ArrayBookLoan to file Successful");
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }

        try{
            FileWriter writer = new FileWriter("SizeOfArray.txt");
            writer.write(
                    library.getArrayBooks().size()+"\n"+
                        library.getArrayStudents().size()+"\n"+
                        library.getArrayLibraryManagers().size()+"\n"+
                        library.getArrayBookLoans().size()
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

    }

    public void loadLibraryData(Library library,libraryAdmin admin){
        int sizeOfBooksArray = 0,sizeOfStudentArray = 0,sizeOfLibraryManagerArray = 0,sizeOfBookLoansArray = 0;
        try{
            Scanner scan = new Scanner(new FileReader("SizeOfArray.txt"));
            sizeOfBooksArray = scan.nextInt();
            sizeOfStudentArray = scan.nextInt();
            sizeOfLibraryManagerArray = scan.nextInt();
            sizeOfBookLoansArray = scan.nextInt();
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
        int stuID = Integer.parseInt(parts[3]);
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
    private static BookLoan getBookLoan(String line){

        String[] parts = line.split(",");
        if (parts.length < 21) {
            System.out.println("Invalid BookLoan data: " + line);
            return null;
        }
        BookLoan loan = new BookLoan();

        Book book = new Book();
        String title = parts[0],author = parts[1];
        int  pageCount = Integer.parseInt(parts[2]),yearPublished =Integer.parseInt( parts[3]);
        Boolean toExist = Boolean.parseBoolean((parts[4]));
        book.setTitle(title);
        book.setAuthor(author);
        book.setPageCount(pageCount);
        book.setYearPublished(yearPublished);
        book.setToExist(toExist);

        Student student =new Student();
        String firstNameStudent = parts[5],lastNameStudent = parts[6],major = parts[7];
        int stuID = Integer.parseInt(parts[8]);
        LocalDate date = LocalDate.parse(parts[9]);
        student.setFirstName(firstNameStudent);
        student.setLastName(lastNameStudent);
        student.setMajor(major);
        student.setStudentId(stuID);
        student.setMemberShipDate(date);

        libraryManager giverManager = new libraryManager();
        String firstNameGiverManager = parts[10],lastNameGiverManager = parts[11];
        Long userIdGiver = Long.parseLong(parts[12]);
        giverManager.setFirstName(firstNameGiverManager);
        giverManager.setLastName(lastNameGiverManager);
        giverManager.setUserId(userIdGiver);

        libraryManager ReceiverManager = new libraryManager();
        String firstNameReceiverManager = parts[13],lastNameReceiverManager = parts[14];
        Long userIdReceiver = Long.parseLong(parts[15]);
        ReceiverManager.setFirstName(firstNameReceiverManager);
        ReceiverManager.setLastName(lastNameReceiverManager);
        ReceiverManager.setUserId(userIdReceiver);

        LocalDate borrowDate = LocalDate.parse(parts[16]);
        LocalDate dueDate = LocalDate.parse(parts[17]);
        LocalDate actualReturn = LocalDate.parse(parts[18]);
        Period laterTime = Period.parse(parts[19]);
        int countLoan = Integer.parseInt(parts[20]);

        loan.setBookLoan(book);
        loan.setStudentBookLoan(student);
        loan.setGiverManager(giverManager);
        loan.setReceiverManager(ReceiverManager);
        loan.setBorrowDate(borrowDate);
        loan.setDueDate(dueDate);
        loan.setActualReturn(actualReturn);
        loan.setLaterTime(laterTime);
        loan.setCountLoan(countLoan);

        return loan;
    }


}
