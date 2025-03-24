package exercises.ex2.EX2_PM_1_4;

import java.util.Scanner;

public class Main_EX2_PM_1_4 {
    public static void main(String[] args) {
        while(true) {
            System.out.print("please enter a character (w , a , s , d , q): ");
            Scanner input = new Scanner(System.in);
            char character = input.next().charAt(0);
            switch(character) {
                case 'w':
                case 'W':
                    System.out.println("UP");
                    break;

                case 'a':
                case 'A':
                    System.out.println("LEFT");
                    break;

                case 's':
                case 'S':
                    System.out.println("DOWN");
                    break;

                case 'd':
                case 'D':
                    System.out.println("RIGHT");
                    break;

                case 'q':
                case 'Q':
                    System.out.println("EXIT");
                    break;

                default:
                    System.out.println("WARNING");
                    break;
            }
        }
    }
}
