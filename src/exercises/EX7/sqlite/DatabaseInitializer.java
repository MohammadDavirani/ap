package exercises.EX7.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    private static final String URL = "jdbc:sqlite:library.db";

    public static void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS books (" +
                            "title TEXT PRIMARY KEY, " +
                            "author TEXT, " +
                            "pageCount INTEGER, " +
                            "yearPublished INTEGER, " +
                            "toExist BOOLEAN)"
            );

            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS students (" +
                            "studentId INTEGER PRIMARY KEY, " +
                            "firstName TEXT, " +
                            "lastName TEXT, " +
                            "major TEXT, " +
                            "memberShipDate DATE)"
            );


            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS managers (" +
                            "userId INTEGER PRIMARY KEY, " +
                            "firstName TEXT, " +
                            "lastName TEXT)"
            );

            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS bookloans (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "bookTitle TEXT, " +
                            "studentId INTEGER, " +
                            "giverId INTEGER, " +
                            "receiverId INTEGER, " +
                            "borrowDate DATE, " +
                            "dueDate DATE, " +
                            "actualReturn DATE, " +
                            "FOREIGN KEY(bookTitle) REFERENCES books(title), " +
                            "FOREIGN KEY(studentId) REFERENCES students(studentId), " +
                            "FOREIGN KEY(giverId) REFERENCES managers(userId), " +
                            "FOREIGN KEY(receiverId) REFERENCES managers(userId))"
            );

            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS requests (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "studentId INTEGER, " +
                            "bookTitle TEXT, " +
                            "date DATE, " +
                            "FOREIGN KEY(studentId) REFERENCES students(studentId), " +
                            "FOREIGN KEY(bookTitle) REFERENCES books(title))"
            );


            System.out.println("✅ Database tables created successfully.");

        } catch (SQLException e) {
            System.err.println("❌ Database initialization failed: " + e.getMessage());
        }
    }
}

