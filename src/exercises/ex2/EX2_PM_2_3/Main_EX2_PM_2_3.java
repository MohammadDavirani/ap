package exercises.ex2.EX2_PM_2_3;

import java.io.*;
import java.util.Scanner;

public class Main_EX2_PM_2_3 {
    public static void main(String[] args) throws IOException {
        System.out.print("==========Welcome to the game Pacman==========\n");

        System.out.print("Use buttons for w(up), a(left) , d(right) and s(down) \n Also, Press q for quit\n ");
        System.out.print("Enter Y to continue: \n ");

        char[][] board = new char[0][];
        char ch;
        int number=0, counterSpace = 0, food = 0, totalFood = 0, leftOverFood = 0, score = 0, moveX_i = 0, moveX_j = 0;
        Scanner input = new Scanner(System.in);
        ch = input.next().charAt(0);
        if (ch != 'Y' && ch != 'y') {
            System.out.print("Exit Game! ");
            return;
        }

        File file = new File("savePacMan.txt");
        if (file.exists()) {
            System.out.print("Do you want play saved game?: press(y/n)\n");
            ch = input.next().charAt(0);
            switch(ch) {
                case 'y':
                case 'Y':
                    try(FileReader ReadFromFile = new FileReader("savePacMan.txt")){
                        number = ReadFromFile.read();
                        totalFood = ReadFromFile.read();
                        leftOverFood = ReadFromFile.read();
                        score = ReadFromFile.read();
                        moveX_i = ReadFromFile.read();
                        moveX_j = ReadFromFile.read();
                        board = new char[number+2][number+2];
                        for(int i=0;i<number+2;i++) {
                            for (int j=0;j<number+2;j++) {
                                board[i][j] = (char) ReadFromFile.read();
                            }
                        }
                    }
                    break;

                case 'n':
                case 'N':
                    System.out.print("please enter a number: ");
                    number = input.nextInt();
                    board = new char[number + 2][number + 2];
                    for (int i = 0; i < number + 2; i++) {
                        for (int j = 0; j < number + 2; j++) {
                            if (i == 0 || i == number + 1 || j == 0 || j == number + 1) {
                                board[i][j] = '*';
                            }
                            if (i > 0 && i < number + 1 && j > 0 && j < number + 1) {
                                board[i][j] = ' ';
                                counterSpace++;
                            }
                        }
                    }

                    moveX_i = number / 2;
                    moveX_j = number / 2;
                    board[moveX_i][moveX_j] = 'C';

                    do {
                        System.out.format("please enter a number between (1 & %d): ", counterSpace);
                        food = input.nextInt();
                    } while (food < 1 || food > counterSpace);
                    totalFood = food;
                    leftOverFood = food;
                    while (food > 0) {

                        int random_i = (int) (Math.random() * number) + 1;
                        int random_j = (int) (Math.random() * number) + 1;

                        if (board[random_i][random_j] != '*' && board[random_i][random_j] != '.' && board[random_i][random_j] != 'C') {
                            board[random_i][random_j] = '.';
                            food--;

                        }

                    }
                    break;
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

                case 'q':
                case 'Q':

                    break;
            }
            if(direction_X == 'q' || direction_X == 'Q') {
                break;
            }
        }
        long finish = System.currentTimeMillis();
        long timeElapsed = (finish - start)/1000;

        System.out.format("Your Total Score = %d\n",score);
        System.out.format("The  time of the game = %d s\n",timeElapsed);

        System.out.print("Do you want save the game? press(y/n)");
        ch = input.next().charAt(0);
        switch(ch) {
            case 'y':
            case 'Y':
                try (FileWriter writeToFile = new FileWriter("savePacMan.txt")) {
                    writeToFile.write(number);
                    writeToFile.write(totalFood);
                    writeToFile.write(leftOverFood);
                    writeToFile.write(score);
                    writeToFile.write(moveX_i);
                    writeToFile.write(moveX_j);
                    for (int i=0;i<number+2;i++) {
                        for (int j=0;j<number+2;j++) {
                            writeToFile.write(board[i][j]);
                        }
                    }
                }
                System.out.print("Game save successfully.");
                break;

            case 'n':
            case 'N':
                System.out.print("See you later :)");
                break;
        }
    }
}
