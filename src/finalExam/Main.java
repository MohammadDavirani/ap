package finalExam;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Product book1 = new Book("Book",1000,"Reza","farsi");
        Product book2 = new Book("Book",1500,"Ali","english");
        Product book3 = new Book("Book",1500,"Ali","english");
        Product book4 = new Book("Book",1700,"mohammad","math");
        Product book5 = new Book("Book",900,"Koroush","computer");


        Product pen1 =new Pen("Pen",900,Color.Green);
        Product pen2 =new Pen("Pen",950,Color.Red);
        Product pen3 =new Pen("Pen",800,Color.Blue);
        Product pen4 =new Pen("Pen",800,Color.Blue);
        Product pen5 =new Pen("Pen",1000,Color.Black);

        ProductManager productManager =new ProductManager();

        productManager.addToProductList(book1);
        productManager.addToProductList(book2);
        productManager.addToProductList(book3);
        productManager.addToProductList(book4);
        productManager.addToProductList(book5);
        productManager.addToProductList(pen1);
        productManager.addToProductList(pen2);
        productManager.addToProductList(pen3);
        productManager.addToProductList(pen4);
        productManager.addToProductList(pen5);

        ProductTools.displayProductsInformation(productManager.getProductsList());

        Map<String, Product> expensive = ProductTools.expensiveBookAndPen(productManager.getProductsList());
        System.out.println("\n\nBook: " + expensive.get("Book"));
        System.out.println("Pen: " + expensive.get("Pen"));
    }
}
