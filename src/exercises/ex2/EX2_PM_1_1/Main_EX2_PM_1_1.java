package exercises.ex2.EX2_PM_1_1;

import java.util.Scanner;

public class Main_EX2_PM_1_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        int number = input.nextInt();

        for(int i=1;i<=number+2;i++) {
            if(i == 1 || i==number+2) {
                for(int j=0;j<number;j++) {
                    System.out.print("*");
                }
                System.out.print("\n");
            }

            if(i>1 && i<number +2){
                System.out.print("*");
                for(int j=0;j<number-2;j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
                System.out.print("\n");
            }
        }
    }
}
