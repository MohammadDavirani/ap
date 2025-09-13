package finalExam;

import java.util.Objects;

public class Product {
    private String name;
    private int price;


    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public void setName(String name) { this.name = name; }
    public void setPrice(int price) { this.price = price; }



    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return price == product.price &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
