package exercises.ex2.EX2_PM_1_2;

import java.util.Scanner;

public class Main_EX2_PM_1_2 {
    public static void main(String[] args) {
        System.out.print("please enter a number: ");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        char[][] board = new char[number+2][number+2];

        for(int i=0;i<number;i++){
            for(int j=0;j<number+2;j++) {
                if(j==0 || j == number+1) {
                    board[i][j] = '*';
                }
                if(i==0 || i == number-1) {
                    board[i][j] = '*';
                }
                if(i>=1 && i<number-1) {
                    if(j>=1 && j<=number) {
                        board[i][j] = ' ';
                    }
                }
            }
        }
        for(int i=0;i<number+2;i++) {
            for(int j=0;j<number+2;j++){
                if(i>=10 && i<number+2) {
                    board[i][j] = ' ';
                }
            }
        }

        for(int i=0;i<number+2;i++){
            for(int j=0;j<number+2;j++) {
                System.out.format("%c",board[i][j]);
            }
            System.out.print("\n");
        }
    }
}
