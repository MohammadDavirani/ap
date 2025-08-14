package Projects.finalproject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

// saving students and books information on the file
public class dataFile implements Serializable {
    private final String studentData = "studentData.bin";
    private final String bookData = "bookData.bin";
    private final String requestBookData = "requestBookData.bin";
    private final String adminData = "adminData.bin";
    private final String activeRequestData = "activeRequestData.bin";
    private final String returnBooksRequestedData = "returnBooksRequestedData.bin";

    public void saveLibraryDataToFile(LibrarySystem system){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(studentData)));
            oos.writeObject(system.getStudents());
            oos.close();

            ObjectOutputStream oos2 = new ObjectOutputStream(Files.newOutputStream(Paths.get(bookData)));
            oos2.writeObject(system.getBooks());
            oos2.close();

            ObjectOutputStream oos3 = new ObjectOutputStream(Files.newOutputStream(Paths.get(requestBookData)));
            oos3.writeObject(system.getRequests());
            oos3.close();

            ObjectOutputStream oos4 = new ObjectOutputStream(Files.newOutputStream(Paths.get(adminData)));
            oos4.writeObject(system.getAdmins());
            oos4.close();

            ObjectOutputStream oos5 = new ObjectOutputStream(Files.newOutputStream(Paths.get(activeRequestData)));
            oos5.writeObject(system.getActiveRequests());
            oos5.close();

            ObjectOutputStream oos6 = new ObjectOutputStream(Files.newOutputStream(Paths.get(returnBooksRequestedData)));
            oos6.writeObject(system.getReturnBooksRequested());
            oos6.close();

        }catch(IOException e){
            System.out.println("Error" + e.getMessage());
        }
    }

    public void loadLibraryDataFromFile(LibrarySystem system){
        try{
            ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(studentData)));
            system.setStudent((List<Student>) ois.readObject());
            ois.close();

            ObjectInputStream ois2 = new ObjectInputStream(Files.newInputStream(Paths.get(bookData)));
            system.setBook((List<Book>) ois2.readObject());
            ois2.close();

            ObjectInputStream ois3 = new ObjectInputStream(Files.newInputStream(Paths.get(requestBookData)));
            system.setBookRequests((List<BooksRequested>) ois3.readObject());
            ois3.close();

            ObjectInputStream ois4 = new ObjectInputStream(Files.newInputStream(Paths.get(adminData)));
            system.setAdmin((List<Admin>) ois4.readObject());
            ois4.close();

            ObjectInputStream ois5 = new ObjectInputStream(Files.newInputStream(Paths.get(activeRequestData)));
            system.setActiveRequests((List<ActiveRequest>) ois5.readObject());
            ois5.close();

            ObjectInputStream ois6 = new ObjectInputStream(Files.newInputStream(Paths.get(returnBooksRequestedData)));
            system.setReturnBooksRequested((List<ReturnBooksRequested>) ois6.readObject());
            ois6.close();

        }catch(IOException e){
            System.out.println("Error" + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
