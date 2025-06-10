package exercises.EX7;

import Projects.Library.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TabSplitFile {

    public ArrayList<Library> load() throws IOException {
        ArrayList<Library> libraries = new ArrayList<>();

        ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get("LibraryWithTabSplitFile.txt")));
        Library currentLibrary = null;

        for (String line : lines) {
            if (line.trim().equals("----")) {
                if (currentLibrary != null) {
                    libraries.add(currentLibrary);
                    currentLibrary = null;
                }
                continue;
            }

            String[] parts = line.split("\t");
            String tag = parts[0];

            switch (tag) {
                case "LibraryName":
                    currentLibrary = new Library();
                    currentLibrary.setLibraryName(parts[1]);
                    break;

                case "Books":
                    if (currentLibrary != null) {
                        for (int i = 1; i < parts.length; i++) {
                            currentLibrary.addBook(new Book(parts[i]));
                        }
                    }
                    break;

                case "Students":
                    if (currentLibrary != null) {
                        for (int i = 1; i < parts.length; i++) {
                            currentLibrary.addStudent(new Student(parts[i]));
                        }
                    }
                    break;

                case "Managers":
                    if (currentLibrary != null) {
                        for (int i = 1; i < parts.length; i++) {
                            currentLibrary.addManager(new libraryManager(parts[i]));
                        }
                    }
                    break;

                case "BookLoans":
                    if (currentLibrary != null) {
                        for (int i = 1; i < parts.length; i++) {
                            currentLibrary.addLoan(new BookLoan(parts[i]));
                        }
                    }
                    break;

                case "Requests":
                    if (currentLibrary != null) {
                        for (int i = 1; i < parts.length; i++) {
                            currentLibrary.addRequest(new Request(parts[i]));
                        }
                    }
                    break;
            }
        }
        if (currentLibrary != null) {
            libraries.add(currentLibrary);
        }

        return libraries;
    }


    public void saveLibraryData(Library library) throws Exception {
        try (
                PrintWriter pw = new PrintWriter(Files.newOutputStream(new File("LibraryWithTabSplitFile.txt").toPath()))
        ) {
            pw.println("LibraryName\t" + library.getLibraryName());

            pw.print("Books\t");
            for (Book book : library.getArrayBooks()) {
                pw.print(book.toString() + "\t");
            }
            pw.println();

            pw.print("Students\t");
            for (Student student : library.getArrayStudents()) {
                pw.print(student.toString() + "\t");
            }
            pw.println();

            pw.print("Managers\t");
            for (libraryManager manager : library.getArrayLibraryManagers()) {
                pw.print(manager.toString() + "\t");
            }
            pw.println();

            pw.print("BookLoans\t");
            for (BookLoan loan : library.getArrayBookLoans()) {
                pw.print(loan.toString() + "\t");
            }
            pw.println();

            pw.print("Requests\t");
            for (Request request : library.getArrayRequest()) {
                pw.print(request.toString() + "\t");
            }
            pw.println();

            pw.println("----");
        }
    }


}
