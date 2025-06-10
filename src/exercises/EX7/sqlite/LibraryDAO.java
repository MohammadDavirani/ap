package exercises.EX7.sqlite;

import Projects.Library.DBConnection;
import Projects.Library.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryDAO {

    public void saveLibrary(Library library) throws SQLException {
        // ذخیره کتاب‌ها
        for (Book book : library.getArrayBooks()) {
            saveBook(book);
        }

        // ذخیره دانش‌آموزان
        for (Student student : library.getArrayStudents()) {
            saveStudent(student);
        }

        // ذخیره مدیران
        for (libraryManager manager : library.getArrayLibraryManagers()) {
            saveManager(manager);
        }

        // ذخیره امانت‌ها
        for (BookLoan loan : library.getArrayBookLoans()) {
            saveBookLoan(loan);
        }

        // ذخیره درخواست‌ها
        for (Request request : library.getArrayRequest()) {
            saveRequest(request);
        }
    }

    public Library loadLibrary() throws SQLException {
        Library library = new Library();


        for (Book request : loadAllBooks()) {
            library.addBook(request);
        }
        for (Student request : loadAllStudents()) {
            library.addStudent(request);
        }
        for (libraryManager request : loadAllManagers()) {
            library.addManager(request);
        }
        for (BookLoan request : loadAllBookLoans()) {
            library.addLoan(request);
        }
        for (Request request : loadAllRequests()) {
            library.addRequest(request);
        }
        return library;
    }


    private void saveBook(Book book) throws SQLException {
        String sql = "INSERT INTO books(title, author, pageCount, yearPublished, toExist) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Projects.Library.DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setInt(3, book.getPageCount());
            pstmt.setInt(4, book.getYearPublished());
            pstmt.setBoolean(5, book.isToExist());
            pstmt.executeUpdate();
        }
    }

    private void saveStudent(Student student) throws SQLException {
        String sql = "INSERT INTO students(firstName, lastName, major, studentId, memberShipDate) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Projects.Library.DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getFirstName());
            pstmt.setString(2, student.getLastName());
            pstmt.setString(3, student.getMajor());
            pstmt.setLong(4, student.getStudentId());
            pstmt.setDate(5, Date.valueOf(student.getMemberShipDate()));
            pstmt.executeUpdate();
        }
    }

    private void saveManager(libraryManager manager) throws SQLException {
        String sql = "INSERT INTO managers(firstName, lastName, userId) VALUES (?, ?, ?)";
        try (Connection conn = Projects.Library.DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, manager.getFirstName());
            pstmt.setString(2, manager.getLastName());
            pstmt.setLong(3, manager.getUserId());
            pstmt.executeUpdate();
        }
    }

    private void saveBookLoan(BookLoan loan) throws SQLException {
        String sql = "INSERT INTO bookloans(bookTitle, studentId, giverId, receiverId, borrowDate, dueDate, actualReturn) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Projects.Library.DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, loan.getBookLoan().getTitle());
            pstmt.setLong(2, loan.getStudent().getStudentId());
            pstmt.setLong(3, loan.getGiverManager().getUserId());
            pstmt.setLong(4, loan.getReceiverManager().getUserId());
            pstmt.setDate(5, Date.valueOf(loan.getBorrowDate()));
            pstmt.setDate(6, Date.valueOf(loan.getDueDate()));
            if (loan.getActualReturn() != null)
                pstmt.setDate(7, Date.valueOf(loan.getActualReturn()));
            else
                pstmt.setNull(7, Types.DATE);
            pstmt.executeUpdate();
        }
    }

    private void saveRequest(Request request) throws SQLException {
        String sql = "INSERT INTO requests(studentId, bookTitle, date) VALUES (?, ?, ?)";
        try (Connection conn = Projects.Library.DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, request.getStudent().getStudentId());
            pstmt.setString(2, request.getBook().getTitle());
            pstmt.setDate(3, Date.valueOf(request.getDate()));
            pstmt.executeUpdate();
        }
    }


    private List<Book> loadAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection conn = Projects.Library.DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Book book = new Book();
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPageCount(rs.getInt("pageCount"));
                book.setYearPublished(rs.getInt("yearPublished"));
                book.setToExist(rs.getBoolean("toExist"));
                books.add(book);
            }
        }
        return books;
    }

    private List<Student> loadAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = Projects.Library.DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Student student = new Student();
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setMajor(rs.getString("major"));
                student.setStudentId(rs.getLong("studentId"));
                student.setMemberShipDate(rs.getDate("memberShipDate").toLocalDate());
                students.add(student);
            }
        }
        return students;
    }

    private List<libraryManager> loadAllManagers() throws SQLException {
        List<libraryManager> managers = new ArrayList<>();
        String sql = "SELECT * FROM managers";
        try (Connection conn = Projects.Library.DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                libraryManager manager = new libraryManager();
                manager.setFirstName(rs.getString("firstName"));
                manager.setLastName(rs.getString("lastName"));
                manager.setUserId(rs.getLong("userId"));
                managers.add(manager);
            }
        }
        return managers;
    }

    private List<BookLoan> loadAllBookLoans() throws SQLException {
        List<BookLoan> loans = new ArrayList<>();
        String sql = "SELECT * FROM bookloans";
        try (Connection conn = Projects.Library.DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                BookLoan loan = new BookLoan();

                Book book = new Book();
                book.setTitle(rs.getString("bookTitle"));
                loan.setBookLoan(book);

                Student student = new Student();
                student.setStudentId(rs.getLong("studentId"));
                loan.setStudentBookLoan(student);

                libraryManager giver = new libraryManager();
                giver.setUserId(rs.getLong("giverId"));
                loan.setGiverManager(giver);

                libraryManager receiver = new libraryManager();
                receiver.setUserId(rs.getLong("receiverId"));
                loan.setReceiverManager(receiver);

                loan.setBorrowDate(rs.getDate("borrowDate").toLocalDate());
                loan.setDueDate(rs.getDate("dueDate").toLocalDate());

                Date actualReturn = rs.getDate("actualReturn");
                if (actualReturn != null)
                    loan.setActualReturn(actualReturn.toLocalDate());

                loans.add(loan);
            }
        }
        return loans;
    }

    private List<Request> loadAllRequests() throws SQLException {
        List<Request> requests = new ArrayList<>();
        String sql = "SELECT * FROM requests";
        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Request req = new Request();

                Student student = new Student();
                student.setStudentId(rs.getLong("studentId"));
                req.setStudent(student);

                Book book = new Book();
                book.setTitle(rs.getString("bookTitle"));
                req.setBook(book);

                req.setDate(rs.getDate("date").toLocalDate());

                requests.add(req);
            }
        }
        return requests;
    }
}

