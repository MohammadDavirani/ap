package exercises.ex2.EX2_PM_2_2;

import java.util.Scanner;

public class Main_EX2_PM_2_2 {
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

        int moveX_i = number/2;
        int moveX_j = number/2;
        board[moveX_i][moveX_j] = 'C';

        int food=0;
        int totalFood=0;
        int leftOverFood=0;
        int score=0;
        do {
            System.out.format("please enter a number between (1 & %d): ",counterSpace);
            food = input.nextInt();
        } while(food<1 || food>counterSpace);
        totalFood = food;
        leftOverFood = food;
        while(food>0) {

            int random_i = (int) (Math.random() * number) + 1;
            int random_j = (int) (Math.random() * number) + 1;

            if(board[random_i][random_j] !='*' && board[random_i][random_j] !='.' && board[random_i][random_j] !='C'){
                board[random_i][random_j] = '.';
                food--;

            }

        }

        long start = System.currentTimeMillis();
        while(leftOverFood !=0)
        {
            System.out.format("Your Total food  = %d\n",totalFood);
            System.out.format("Your left over food  = %d\n",leftOverFood);
            System.out.format("Your Total Score = %d\n",score);
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
                        if(board[moveX_i-1][moveX_j] == '.') {
                            leftOverFood--;
                            score++;
                        }

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
                        if(board[moveX_i][moveX_j-1] == '.') {
                            leftOverFood--;

                            score++;
                        }
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
                        if(board[moveX_i+1][moveX_j] == '.') {
                            leftOverFood--;
                            score++;
                        }
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
                        if(board[moveX_i][moveX_j+1] == '.') {
                            leftOverFood--;
                            score++;
                        }
                        board[moveX_i][moveX_j] = ' ';
                        board[moveX_i][moveX_j+1] = 'C';
                        moveX_j++;
                    }
                    break;
            }

        }
        long finish = System.currentTimeMillis();
        long timeElapsed = (finish - start)/1000;

        System.out.format("Your Total Score = %d\n",score);
        System.out.format("The  time of the game = %d s\n",timeElapsed);

    }
}
