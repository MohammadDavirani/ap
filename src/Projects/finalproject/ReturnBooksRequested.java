package Projects.finalproject;

import java.io.Serializable;

public class ReturnBooksRequested implements Serializable {
    private Student student;
    private Book book;


    public ReturnBooksRequested(Student student, Book book){
        this.student = student;
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public Book getBook() {
        return book;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BooksRequested{" +
                "student=" + student +
                "\n"+
                ", book=" + book +
                '}';
    }
}
