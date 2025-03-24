package exercises.ex2.EX2_PM_2_1;
import java.util.Scanner;

public class Main_EX2_PM_2_1 {
    public static void main(String[] args) {
        System.out.print("please enter a number: ");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        char[][] board = new char[number+2][number+2];
        for(int i=0;i<number+2;i++) {
            for(int j=0;j<number+2;j++) {
                if(i==0 || i==number+1 || j==0 || j ==number+1) {
                    board[i][j] = '*';
                }
                if(i>0 && i<number+1 && j>0 && j<number+1) {
                    board[i][j] =' ';
                }
            }
        }

        int moveX_i = number/2;
        int moveX_j = number/2;
        board[moveX_i][moveX_j] = 'C';

        while(true)
        {
            for(int i=0;i<number+2;i++) {
                for(int j=0;j<number+2;j++) {
                    System.out.format("%c", board[i][j]);
                }
                System.out.print("\n");
            }

            char direction_X= input.next().charAt(0);
            switch(direction_X) {
                case 'w':
                case 'W':
                    System.out.println("UP");
                    if(board[moveX_i-1][moveX_j] == '*') {

                        System.out.println("hitting the game wall!");
                    }
                    if(board[moveX_i-1][moveX_j] != '*') {

                        board[moveX_i][moveX_j] = ' ';
                        board[moveX_i-1][moveX_j] = 'C';
                        moveX_i--;
                    }
                    break;

                case 'a':
                case 'A':
                    System.out.println("LEFT");
                    if(board[moveX_i][moveX_j-1] == '*') {

                        System.out.println("hitting the game wall!");
                    }
                    if(board[moveX_i][moveX_j-1] != '*') {
                        board[moveX_i][moveX_j] = ' ';
                        board[moveX_i][moveX_j-1] = 'C';
                        moveX_j--;
                    }
                    break;

                case 's':
                case 'S':
                    System.out.println("DOWN");
                    if(board[moveX_i+1][moveX_j] == '*') {

                        System.out.println("hitting the game wall!");
                    }
                    if(board[moveX_i+1][moveX_j] != '*') {

                        board[moveX_i][moveX_j] = ' ';
                        board[moveX_i+1][moveX_j] = 'C';
                        moveX_i++;
                    }
                    break;

                case 'd':
                case 'D':
                    System.out.println("RIGHT");
                    if(board[moveX_i][moveX_j+1] == '*') {

                        System.out.println("hitting the game wall!");
                    }
                    if(board[moveX_i][moveX_j+1] != '*') {
                        board[moveX_i][moveX_j] = ' ';
                        board[moveX_i][moveX_j+1] = 'C';
                        moveX_j++;
                    }
                    break;
            }

        }
    }
}
