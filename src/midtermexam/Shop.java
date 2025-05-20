package midtermexam;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    private int price;
    private String brand;

    ArrayList<Shop> kala = new ArrayList<>();

    public void addCaseToShop(Case aCase){
        kala.add(aCase);
    }
    public void addLaptopToShop(Laptop laptop){
        kala.add(laptop);
    }

    public ArrayList<Shop> getKala() {
        return kala;
    }
    public void setKala(ArrayList<Shop> kala) {
        this.kala = kala;
    }

    public Shop(){

    }

    public Shop(int price, String brand) {
        this.price = price;
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "price=" + price +
                ", brand='" + brand + '\'' +
                '}';
    }

    public void printKala(){
        for(int i=0;i<getKala().size();i++){
            System.out.println(getKala().get(i));
        }
    }

    public void search(){
        System.out.println("---- Menu ---");
        System.out.println("1. Search case");
        System.out.println("2. Search laptop");

        Scanner input = new Scanner(System.in);
        int question = input.nextInt();

        switch(question){
            case 1:
                String model , brand;
                System.out.println("brand: ");
                brand = input.next();
                for(int i=0;i<getKala().size();i++) {
                    Shop shop = getKala().get(i);
                    if(shop.getBrand().equals(brand)){
                        System.out.println(getKala().get(i));
                    }
                }
                break;

            case 2:
                System.out.println("brand: ");
                brand = input.next();
                for(int i=0;i<getKala().size();i++) {
                    Shop shop = getKala().get(i);
                    if(shop.getBrand().equals(brand)){
                        System.out.println(getKala().get(i));
                    }
                }
                break;

            default:
                System.out.println("Invalid Number!");
                break;
        }
    }
}
