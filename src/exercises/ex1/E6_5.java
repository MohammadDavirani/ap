package exercises.ex1;
import java.util.Scanner;

public class E6_5 {
    public static void main(String[] args) {
        System.out.print("enter a number for length of floating point numbers:");

        int length;
        Scanner input = new Scanner(System.in);
        length = input.nextInt();

        double[] numbers = new double[length];
        for (int i = 0; i < length; i++) {
            System.out.format("number[%d] = ", i + 1);
            numbers[i] = input.nextDouble();
        }

        System.out.format("\n\nlist of number:\n");
        for (int i = 0; i < length; i++) {
            System.out.format("number[%d] = %.2f\n", i + 1, numbers[i]);
        }

        int choice;
        do {
            System.out.println("========== Welcome ==========");
            System.out.println("1.the average of the values.");
            System.out.println("2.the smallest of the values.");
            System.out.println("3.the largest of the values.");
            System.out.println("4.the range, that is the difference between the smallest and largest.");
            System.out.println("5.Exit");

            System.out.print("choose one of this option: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    averageValue(numbers, length);
                    break;

                case 2:
                    smallestValues(numbers, length);
                    break;

                case 3:
                    largestValues(numbers, length);
                    break;

                case 4:
                    range(numbers, length);
                    break;
            }
        } while (choice != 5);

    }

    public static void averageValue(double[] numbers, int length) {
        double sum = 0;
        for (int i = 0; i < length; i++) {
            sum = sum + numbers[i];
        }
        double average = 0;
        average = sum / length;
        System.out.format("average is: %.2f\n\n", average);
    }

    public static void smallestValues(double[] numbers, int length) {
        int index = 0;
        double min = numbers[0];
        for (int i = 1; i < length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
                index = i;
            }
        }
        System.out.format("\nminimum is: %.2f\n\n", numbers[index]);
    }

    public static void largestValues(double[] numbers, int length) {
        double max = numbers[0];
        int index = 0;
        for (int i = 1; i < length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                index = i;
            }
        }
        System.out.format("\nmaximum is : %.2f\n\n", numbers[index]);
    }

    public static void range(double[] numbers, int length) {

        double max = numbers[0], min = numbers[0];

        for (int i = 1; i < length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        for (int i = 1; i < length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }

        double range = max - min;

        System.out.format("\nrange is : %.2f\n\n",range);
    }
}
