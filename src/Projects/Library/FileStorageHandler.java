package Projects.Library;

import java.io.FileWriter;
import java.io.IOException;

public class FileStorageHandler {
    public void saveLibraryData(Library library){
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
            System.out.println("Successful.");

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
            System.out.println("Successful.");
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
            System.out.println("Successful.");
            writer.close();
        }catch(IOException e){
            System.out.println("Error: "+ e.getMessage());
        }

        try{
            FileWriter writer = new FileWriter("BookLoans.txt");
            for(int i=0;i<library.getArrayBookLoans().size();i++){
                bookLoan loan = library.getArrayBookLoans().get(i);
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
                        loan.getCountBookLoan()+"\n"
                );
            }
            writer.close();
            System.out.println("Successful");
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }

    }

    public void loadLibraryData(Library library){

    }

    public void exportReports(){

    }

}
