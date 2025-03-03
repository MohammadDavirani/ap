package Exercises_1;

import java.util.Scanner;

public class E5_2
{
    public static void main(String[] args)
    {
        System.out.print("Enter a number:");
        Scanner number = new Scanner(System.in);

        double num = number.nextDouble();
        if(num==0)
        {
            System.out.println("The number is zero.");
        } else if(num>0)
        {
          System.out.println("The number is positive.");
        }
        else
        {
            System.out.println("The number is negative.");

        }


        double absNum = Math.abs(num);
        if(absNum<1)
        {
            System.out.println("The number is less than 1 so  it's-> Small ");
        }else if(absNum > 1000000)
        {
            System.out.println("The number is greater than 1 million, so it's -> Large ");

        }

    }
}
