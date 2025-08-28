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

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYearOfPublishing(String yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
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