package exercises.EX7.sqlite;

import Projects.Library.DatabaseInitializer;
import Projects.Library.Library;
import Projects.Library.LibraryDAO;
import Projects.Library.SampleDataGenerator;

public class Main_SqLite {

    public static void main(String[] args) {
        try {
            System.out.println("Initializing database...");
            DatabaseInitializer.initializeDatabase();

            Library library = SampleDataGenerator.createSampleLibrary();

            Projects.Library.LibraryDAO dao = new LibraryDAO();
            dao.saveLibrary(library);
            System.out.println("Sample library saved to the database.");

            Library loadedLibrary = dao.loadLibrary();
            System.out.println("Library loaded from database:");
            System.out.println("Books: " + loadedLibrary.getArrayBooks().size());
            System.out.println("Students: " + loadedLibrary.getArrayStudents().size());
            System.out.println("Managers: " + loadedLibrary.getArrayLibraryManagers().size());
            System.out.println("Loans: " + loadedLibrary.getArrayBookLoans().size());
            System.out.println("Requests: " + loadedLibrary.getArrayRequest().size());

        } catch (Exception e) {
            System.err.println("Error during execution:");
            e.printStackTrace();
        }
    }
}

