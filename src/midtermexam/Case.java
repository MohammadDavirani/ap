package midtermexam;

public class Case extends Shop{
    private int power;
    private String brand;

    public Case(int price, String model, int power, String brand1) {
        super(price, model);
        this.power = power;
        this.brand = brand1;
    }

    public int getPower() {
        return power;
    }
    public String getBrand() {
        return brand;
    }

    public void setPower(int power) {
        this.power = power;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Case{" +
                "price=" + super.getPrice() +
                ",model=" + super.getBrand()+
                ",power=" + power +
                ", brand='" + brand + '\'' +
                '}';
    }


}
