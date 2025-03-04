package Exercises_1;

import java.util.Scanner;

public class E6_17 {
    public static void main(String[] args) {
        System.out.print("please enter a number for side length: ");

        Scanner input = new Scanner(System.in);

        int length = input.nextInt();
        if(length==1)
        {
            System.out.format("* *\n* *");
        }
        if(length>1)
        {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (i == 0 || i == length - 1) {
                        System.out.print("*");
                    }
                    if (i != 0 && i != length - 1) {
                        System.out.print("*");

                    }

                }
                System.out.print(" ");
                for (int k = length + 1; k < length * 2 + 1; k++) {
                    if (i == 0 || i == length - 1) {
                        for (int h = 0; h < length; h++) {
                            if (k == length + 1) {
                                System.out.print("*");
                            }
                        }
                    }
                    if (i != 0 && i != length - 1)
                    {
                        if(k==length+1)
                        {
                            System.out.print("*");
                        }
                        if(k>length+1 && k< length*2)
                        {
                            System.out.print(" ");
                        }
                        if(k==2*length)
                        {
                            System.out.print("*");

                        }
                    }
                }
                System.out.println();
            }
        }
    }
}