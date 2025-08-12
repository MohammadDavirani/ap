package Projects.finalproject;


import java.io.Serializable;

public class BooksRequested implements Serializable {
    private Student student;
    private Book book;

    public BooksRequested(Student student, Book book){
        this.student = student;
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
