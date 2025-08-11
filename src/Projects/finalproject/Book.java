package Projects.finalproject;

import java.io.Serializable;

public class Book implements Serializable {
    private String author;
    private String title;
    private String yearOfPublishing;
    private boolean exist;

    public Book(String author, String title, String yearOfPublishing, boolean exist){
        this.author = author;
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
        this.exist = exist;
    }

    public String getAuthor(){
        return author;
    }
    public String getTitle(){
        return title;
    }
    public String getYearOfPublishing(){
        return yearOfPublishing;
    }
    public boolean getExist(){
        return exist;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", yearOfPublishing='" + yearOfPublishing + '\'' +
                ", exist=" + exist +
                '}';
    }
}