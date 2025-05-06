package quiz;

public class Pen extends prices {
    private  String Color;
    private String Brand;
    public Pen(int price) {
        super(price);
    }

    public Pen(int price, String color, String brand) {
        super(price);
        Color = color;
        Brand = brand;
    }

}
