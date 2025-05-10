package Projects.Library;

public class Book {
    private String title;
    private String author;
    private int pageCount;
    private int yearPublished;
    private boolean toExist;

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
}
