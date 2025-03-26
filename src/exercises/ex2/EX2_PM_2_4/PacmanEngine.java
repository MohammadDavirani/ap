package exercises.ex2.EX2_PM_2_4;

import java.io.*;
import java.util.Scanner;

public class PacmanEngine {

    int number;
    int counterSpace=0;
    int food;
    int totalFood;
    int leftOverFood;
    int score;
    int moveX_i;
    int moveX_j;
    long timeElapsed;

    char ch;
    char[][] board;

    public PacmanEngine(int k,int c){
        number = k;
        food = c;
    }

    public void printMatrix() {
        File file = new File("savePacMan.txt");
        if(file.exists()) {
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
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

            totalFood =food;
            leftOverFood=food;

            while (food > 0) {

                int random_i = (int) (Math.random() * number) + 1;
                int random_j = (int) (Math.random() * number) + 1;

                if (board[random_i][random_j] != '*' && board[random_i][random_j] != '.' && board[random_i][random_j] != 'C') {
                    board[random_i][random_j] = '.';
                    food--;

                }
            }
        }

        for (int i = 0; i < number + 2; i++) {
            for (int j = 0; j < number + 2; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public void printScore() {
        System.out.format("Your Score = %d\n",score);
    }

    public void printRemainTime() {
        System.out.format("The  time of the game = %d s\n",timeElapsed);
    }

    public void move(int direction) {

        long start = System.currentTimeMillis();

        System.out.format("Your Total food  = %d\n",totalFood);
        System.out.format("Your left over food  = %d\n",leftOverFood);
        System.out.format("Your Total Score = %d\n",score);

        for (int i = 0; i < number + 2; i++) {
            for (int j = 0; j < number + 2; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

        switch(direction) {
            case 0:
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

            case 3:
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

            case 2:
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

            case 1:
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

        long finish = System.currentTimeMillis();
        timeElapsed = (finish - start) / 1000;
    }

    public void save() throws IOException {
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
    }
}