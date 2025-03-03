package Exercises_1;
import java.util.Scanner;

public class E6_8 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("please enter a word: ");
        String word = input.nextLine();

        int length = word.length();

        for(int i=0;i<length;i++) {
            char ch = word.charAt(i);
            System.out.format("%c\n",ch);
        }
    }
}
