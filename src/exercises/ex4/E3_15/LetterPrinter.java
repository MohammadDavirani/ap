package exercises.ex4.E3_15;

public class LetterPrinter {
    public static void main(String[] args){

        Letter l = new Letter("mmd" , "ali");
        l.addLine("salam");
        l.addLine("khodafez");
        l.addLine("khodafez22222");

        System.out.println(l.getText());

        System.out.println("Dear John:");
        System.out.println("I am sorry we must part.");
        System.out.println("I wish you all the best.");
        System.out.println("Sincerely,");
        System.out.println("Mary");
    }
}
