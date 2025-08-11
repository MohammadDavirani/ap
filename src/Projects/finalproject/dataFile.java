package Projects.finalproject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

// saving students and books information on the file
public class dataFile implements Serializable {
    private final String studentData = "studentData.bin";
    private final String bookData = "bookData.bin";

    public void saveLibraryDataToFile(LibrarySystem system){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(studentData)));
            oos.writeObject(system.getStudents());
            oos.close();
            ObjectOutputStream oos2 = new ObjectOutputStream(Files.newOutputStream(Paths.get(bookData)));
            oos2.writeObject(system.getStudents());
            oos2.close();
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
        }catch(IOException e){
            System.out.println("Error" + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
