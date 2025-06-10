package Projects.Library;

import java.time.LocalDate;

public class Request {
    Student student;
    Book book;
    LocalDate date;

    public Request(){

    }

    public Request(String line) {
        String[] parts = line.split(";");
        this.student = new Student(parts[0].trim());
        this.book = new Book(parts[1].trim());
        this.date = LocalDate.parse(parts[2].trim());
    }

    public Request(Student student2, Book book2, LocalDate now) {
        this.student = student2;
        this.book= book2;
        this.date = now;
    }

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
