package Projects.Library;

import java.time.LocalDate;

public class Request {
    Student student;
    Book book;
    LocalDate date;

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Request{" +
                "student=" + student +
                ", book=" + book +
                '}';
    }
}
