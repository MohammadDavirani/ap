package finalExam;

public class Pen extends Product {
    private Color color;

    public Pen(String name, int price, Color color) {
        super(name, price);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() +
                "color=" + color +
                '}';
    }
}
