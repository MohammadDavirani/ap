package exercises.EX7.sqlite;

import Projects.Library.*;

import java.time.LocalDate;

public class SampleDataGenerator {
    public static Library createSampleLibrary() {
        Library library = new Library();

        Book book1 = new Book("Java Basics", "John Smith", 300, 2020, true);
        Book book2 = new Book("Database Systems", "Elmasri", 500, 2018, true);

        Student student1 = new Student("Ali", "Rezaei", "Computer", 1001L, LocalDate.now());
        Student student2 = new Student("Sara", "Ahmadi", "IT", 1002L, LocalDate.now());

        libraryManager manager1 = new libraryManager("Reza", "Moradi", 2001);
        libraryManager manager2 = new libraryManager("Mina", "Sadeghi", 2002);

        BookLoan loan = new BookLoan(book1, student1, manager1, manager2,
                LocalDate.now().minusDays(5), LocalDate.now().plusDays(10), null);

        Request request = new Request(student2, book2, LocalDate.now());

        library.addBook(book1);
        library.addBook(book2);
        library.addStudent(student1);
        library.addStudent(student2);
        library.addManager(manager1);
        library.addManager(manager2);
        library.addLoan(loan);
        library.addRequest(request);

        return library;
    }
}
