package exercises.ex1;
import java.util.Scanner;

public class E6_13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("please enter a number: ");
        int number = input.nextInt();

        int reminder,external;

        while(number>0)
        {
            reminder = number % 2;
            System.out.format("%d \n",reminder);

            external = number / 2;
            number =  external;
        }
    }
}
