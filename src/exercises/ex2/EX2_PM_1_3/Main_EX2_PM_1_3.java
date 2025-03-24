package exercises.ex2.EX2_PM_1_3;

import java.util.Scanner;

public class Main_EX2_PM_1_3 {
    public static void main(String[] args) {

        System.out.print("please enter a number: ");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        char[][] board = new char[number+2][number+2];
        int counterSpace=0;
        for(int i=0;i<number+2;i++) {
            for(int j=0;j<number+2;j++) {
                if(i==0 || i==number+1 || j==0 || j ==number+1) {
                    board[i][j] = '*';
                }
                if(i>0 && i<number+1 && j>0 && j<number+1) {
                    board[i][j] =' ';
                    counterSpace++;
                }
            }
        }

        int food=0;
        do {
            System.out.format("please enter a number between (1 & %d): ",counterSpace);
            food = input.nextInt();
        } while(food<1 || food>counterSpace);



        while(food>0) {

            int random_i = (int) (Math.random() * number) + 1;
            int random_j = (int) (Math.random() * number) + 1;

            if(board[random_i][random_j] !='*' && board[random_i][random_j] !='.'){
                board[random_i][random_j] = '.';
                food--;

            }

        }

        for(int i=0;i<number+2;i++) {
            for(int j=0;j<number+2;j++) {
                System.out.format("%c", board[i][j]);
            }
            System.out.print("\n");
        }
    }
}
