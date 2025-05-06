package quiz;

public class Book extends prices {
    private String Title;
    public Book(int price) {
        super(price);
    }


    public Book(int price, String title) {
        super(price);
        Title = title;
    }
}
