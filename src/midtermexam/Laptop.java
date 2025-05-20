package midtermexam;

public class Laptop extends Shop{
    private String cpu;
    private int model;

    public Laptop(int price, String brand, String cpu, int model) {
        super(price,brand);
        this.cpu = cpu;
        this.model = model;
    }



    public String getCpu() {
        return cpu;
    }
    public int getModel() {
        return model;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }
    public void setModel(int model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "laptop{" +
                "price=" + super.getPrice() +
                ",model=" + super.getBrand()+
                ",cpu='" + cpu + '\'' +
                ", model=" + model +
                '}';
    }
}
