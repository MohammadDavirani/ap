package exercises.ex1;

import java.util.Scanner;

public class E6_18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("please enter a  number for length of diamond: ");

        int length = input.nextInt();
        int maxStar = (length * 2) - 1;
        int space = (maxStar - 1) / 2;
        int star = 1;
        for (int i = 0; i < length; i++) {

            for (int j = space; j >= 0; j--) {
                System.out.print(" ");
            }
            for (int k = star; k > 0; k--) {
                System.out.print("*");
            }
            System.out.println();
            star = star + 2;
            space--;
        }
        for (int i = length; i >= 0; i--) {
            space++;
            for (int j = space; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = star; k > 0; k--) {
                System.out.print("*");
            }
            star = star - 2;
            System.out.println();
        }
    }
}
