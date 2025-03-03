package Exercises_1;

import java.util.Scanner;

public class E6_3 {
    public static void main(String[] args) {
        System.out.println("=== String Program ===");

        System.out.println("a. Uppercase letters in the string");
        System.out.println("b. Every second letter of the string.");
        System.out.println("c. The string, with all vowels replaced by an underscore.");
        System.out.println("d. The number of vowels in the string");
        System.out.println("e. The positions of all vowels in the string.");


        System.out.format("\n\nPlease enter a string:");
        Scanner input2 = new Scanner(System.in);
        String letter = input2.nextLine();
        System.out.format("\n\nPlease enter one of this option:");
        Scanner input = new Scanner(System.in);
        String choose = input.nextLine();


        int length = letter.length();


        switch (choose) {
            case "a":
            case "A":
                int counterUpper = 0, counterLower = 0;
                for (int i = 0; i < length; i++) {
                    char ch = letter.charAt(i);
                    if (ch == 0x20) {
                        ch = letter.charAt(i + 1);
                        i++;
                    }
                    if (ch >= 'A' && ch <= 'Z') {
                        counterUpper++;
                    } else {
                        counterLower++;
                    }
                }
                System.out.format("counter upper : %d \n counter lower : %d", counterUpper, counterLower);
                break;

            case "b":
            case "B":
                int index1 = 0, index2 = 0;
                for (int i = 0; i < length; i++) {
                    char ch2 = letter.charAt(i);
                    if (ch2 == 0x20) {
                        index1 = i;
                        break;
                    }
                }
                int k = index1 + 1;
                for (int j = k; j < length; j++) {
                    char ch2 = letter.charAt(j);
                    if (ch2 == 0x20) {
                        index2 = j;
                        break;
                    }
                }
                if (index2 == 0) {
                    String secondString = letter.substring(index1);
                    System.out.format("Second string its: %s", secondString);
                    break;
                }
                String secondString = letter.substring(index1, index2);
                System.out.format("Second string its: %s", secondString);
                break;

            case "c":
            case "C":
                for (int i = 0; i < length; i++) {
                    char ch = letter.charAt(i);
                    if (ch == 'a' || ch == 'o' || ch == 'u' || ch == 'e' || ch == 'i') {
                        letter = letter.replace(ch, '_');
                    }
                }
                System.out.format("New string: %s", letter);
                break;

            case "d":
            case "D":
                int counterVowels = 0;
                for (int i = 0; i < length; i++) {

                    char ch = letter.charAt(i);
                    if (ch == 'a' || ch == 'o' || ch == 'u' || ch == 'e' || ch == 'i') {
                        counterVowels++;
                    }
                }
                System.out.format("The number of vowels in the string: %d", counterVowels);
                break;

            case "e":
            case "E":
                for (int i = 0; i < length; i++) {
                    char ch = letter.charAt(i);
                    if (ch == 'a' || ch == 'o' || ch == 'u' || ch == 'e' || ch == 'i') {
                        System.out.format("%d -> %c\n", i, ch);
                    }
                }
                break;
        }
    }

}
