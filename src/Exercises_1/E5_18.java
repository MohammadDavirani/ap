package Exercises_1;

import java.util.Scanner;


public class E5_18 {
    public static void main(String[] args) {
        System.out.println("=====Sorting Program=====");
        System.out.println("Please enter three word:");

        String[] words = new String[3];
        Scanner input = new Scanner(System.in);
        
        for (int i = 0; i < 3; i++) {
            System.out.format("%d) word: ", i + 1);
            words[i] = input.nextLine();
        }

        for(int i=0;i<3;i++) {
                for(int j=0;j<2;j++) {
                    if(words[i].compareTo(words[j])<0) {
                        String temp = words[i];
                        words[i] = words[j];
                        words[j] = temp;
                    }
                }
        }

        System.out.println("Sorted words!");
        for(int i=0;i<3;i++) {
            System.out.format("%d. %s\n",i+1,words[i]);
        }
    }
}
