package Exercises_1;

import java.util.Scanner;

public class E5_15 {
    public static void main(String[] args) {
        System.out.format("\n=== Welcome to the income tax calculation program ===\n\n\n");

        System.out.format("The tax table is as follows:\n\n");

        System.out.println("1.First $50,000              ==> 1% tax");
        System.out.println("2.Over  $50,000  to $75,000  ==> 2% tax");
        System.out.println("3.Over  $75,000  to $100,000 ==> 3% tax");
        System.out.println("4.Over  $100,000 to $250,000 ==> 4% tax");
        System.out.println("5.Over  $250,000 to $500,000 ==> 5% tax");
        System.out.println("6.Over  $500,000             ==> 6% tax");

        System.out.format("\n(***)Attention: There was no separate schedule for single or married taxpayers.\n\n");

        Scanner income = new Scanner(System.in);
        System.out.print("Enter your monthly income: ");
        int Salary = income.nextInt();

        if (Salary < 0) {
            System.out.println("The entered value is not correct.");
        }
        if (Salary < 50000) {
            System.out.println("You are not subject to tax.");
        }

        if (Salary == 50000) {
            System.out.print("Your tax is equal to: ");
            double tax = Salary * .01;
            System.out.format("%.2f", tax);
        }
        if (Salary > 50000 && Salary < 75000) {
            System.out.print("Your tax is equal to: ");
            double tax = Salary * .02;
            System.out.format("%.2f", tax);
        }
        if (Salary > 75000 && Salary < 100000) {
            System.out.print("Your tax is equal to: ");
            double tax = Salary * .03;
            System.out.format("%.2f", tax);
        }
        if (Salary > 100000 && Salary < 250000) {
            System.out.print("Your tax is equal to: ");
            double tax = Salary * .04;
            System.out.format("%.2f", tax);
        }
        if (Salary > 250000 && Salary < 500000) {
            System.out.print("Your tax is equal to: ");
            double tax = Salary * .05;
            System.out.format("%.2f", tax);
        }
        if (Salary > 500000) {
            System.out.print("Your tax is equal to: ");
            double tax = Salary * .06;
            System.out.format("%.2f", tax);
        }

    }
}
