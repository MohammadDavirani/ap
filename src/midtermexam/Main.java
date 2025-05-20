package midtermexam;

public class Main {
    public static void main(String[] args) {
        Shop shop= new Shop();

        Case aCase1 = new Case(10,"hp",500,"zanjan");
        Case aCase2 = new Case(20,"hp",2000,"tehran");

        shop.addCaseToShop(aCase1);
        shop.addCaseToShop(aCase2);

        Laptop laptop1 = new Laptop(1000,"hp","intel",2025);
        Laptop laptop2 = new Laptop(2000,"lenovo","rog",2023);

        shop.addLaptopToShop(laptop1);
        shop.addLaptopToShop(laptop2);

        shop.printKala();

        shop.search();
    }
}
