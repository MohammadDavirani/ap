package Projects.finalproject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BookManager implements Serializable{
    private List<Book> books;

    public BookManager(){
        this.books = new ArrayList<>();
    }
    public  List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    //methods
    public void addBook(String author, String title, String yearOfPublishing, boolean exist){
        if(isTitleTaken(title)){
            System.out.println("This title already exists. Please choose a different title.");
            return;
        }
        Book book = new Book(author, title, yearOfPublishing, exist);
        books.add(book);
        System.out.println("adding book completed successfully.");
    }
    public boolean isTitleTaken(String title){
        return books.stream().
                anyMatch(s -> s.getTitle().equals(title));
    }
    public void isExist(String title, String author){
        Book book = books.stream().
                filter(s-> s.getTitle().equals(title) && s.getAuthor().equals(author))
                .findFirst()
                .orElse(null);

        if(book == null){
            System.out.println("There is no book with these information.");
        }

        if(book.getExist()){
            System.out.println("The book is available");
        }else {
            System.out.println("The book is not available");
        }
    }
    public void displayBooks(){
        System.out.println("\n--- List of Books ---");
        if (books.isEmpty()) {
            System.out.println("No Books have registered yet.");
            return;
        }

        for(Book book : books){
            System.out.println(book);
        }
    }
    public int getBooksCount(){
        return books.size();
    }

    @Override
    public String toString() {
        return "BookManager{" +
                "books=" + books +
                '}';
    }
}
