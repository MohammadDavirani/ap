package Projects.Library;

import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private int pageCount;
    private int yearPublished;
    private boolean toExist= true;

    public Book(){

    }

    public Book(String line) {
        String[] parts = line.split(",");
        this.title = parts[0].split("=")[1];
        this.author = parts[1].split("=")[1];
        this.pageCount = Integer.parseInt(parts[2].split("=")[1].trim());
        this.yearPublished = Integer.parseInt(parts[3].split("=")[1].trim());
        this.toExist = Boolean.parseBoolean(parts[4].split("=")[1].trim());
    }

    public Book(String title, String author, int page, int year, boolean exist) {
        this.title = title;
        this.author = author;
        this.pageCount = page;
        this.yearPublished = year;
        this.toExist = exist;
    }


    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getPageCount() {
        return pageCount;
    }
    public int getYearPublished() {
        return yearPublished;
    }
    public boolean isToExist() {
        return toExist;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }
    public void setToExist(boolean toExist) {
        this.toExist = toExist;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pageCount=" + pageCount +
                ", yearPublished=" + yearPublished +
                ", toExist=" + toExist +
                '}';
    }

    public String toStringTabSplit() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pageCount=" + pageCount +
                ", yearPublished=" + yearPublished +
                ", toExist=" + toExist +
                '}';
    }
}
