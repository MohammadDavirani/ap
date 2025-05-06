package quiz;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        ArrayList<Pen> pens = new ArrayList<>();
        ArrayList<Book> books = new ArrayList<>();

        pens.add(new Pen(1,"Black","x"));
        pens.add(new Pen(2,"yellow","y"));
        books.add(new Book(3,"C"));
        books.add(new Book(4,"Java"));

        for(int i=0;i<2;i++) {
            System.out.println(pens.get(i));
        }
        for(int i=0;i<2;i++) {
            System.out.println(books.get(i));
        }
    }
}
