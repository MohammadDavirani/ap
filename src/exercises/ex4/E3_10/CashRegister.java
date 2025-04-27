package exercises.ex4.E3_10;

public class CashRegister {
    private int item;
    private int totalAmount;
    private String prices;

    public CashRegister() {
        this.item = 0;
        this.totalAmount = 0;
        this.prices = "";
    }

    public int getItem(){
        return item;
    }
    public int getTotalAmount() {
        return totalAmount;
    }

    public void addItem(int price) {
        totalAmount = totalAmount + price;
        ++item;
        prices = prices.concat(String.valueOf(price).concat("\n"));

    }

    public void printReceipt() {
        System.out.println("item : ");
        System.out.println(" "+prices);
        System.out.println("total amount : "+totalAmount);
    }
}
