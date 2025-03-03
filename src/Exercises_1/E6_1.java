package Exercises_1;

import java.util.Scanner;

import static java.lang.System.exit;

public class E6_1 {
    public static void main (String[] args) {

        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        int question,sumEvenNumber=0,userNumber=0,reminder=0,sumOddNumber=0;

        do
        {
            System.out.println("1.(a) The sum of all even numbers between 2 and 100 (inclusive)");
            System.out.println("2.(e) The sum of all odd digits of an input");
            System.out.println("3. Exit");

            System.out.print("Enter one of this option: ");
            question = input.nextInt();

            switch(question)
            {
                case 1 : System.out.println("sum of all even numbers");
                        for(int i =0;i<=100;i++) {
                            if(i %2 ==0) {
                                sumEvenNumber +=i;
                            }
                        }
                         System.out.format("The sum of even numbers is: %d\n\n",sumEvenNumber);
                         exit(1);
                    break;

                case 2 : System.out.print("Please enter a number: ");
                         userNumber = input.nextInt();
                         while(userNumber>0)
                         {
                             reminder = userNumber%10;
                             if(reminder %2 ==1)
                             {
                                 sumOddNumber += reminder;
                             }
                             userNumber = userNumber/10;
                         }
                        System.out.format("The sum of Odd numbers is: %d\n\n",sumOddNumber);
                         sumOddNumber =0;
                    break;

                case 3 :
                    break;
            }

        }while(question !=3);
    }
}
