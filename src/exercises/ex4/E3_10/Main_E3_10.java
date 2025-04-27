package exercises.ex4.E3_10;

public class Main_E3_10 {
    public static void main(String[] args) {
        CashRegister c = new CashRegister();
        c.addItem(10);
        c.addItem(0);
        c.addItem(20);
        c.addItem(2);
        c.addItem(5);
        c.printReceipt();
    }
}
