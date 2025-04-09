package exercises.ex2.EX2_PM_3_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Main_EX2_PM_3_2 extends JPanel {

    final int CELL_SIZE = 5;
    final int WIDTH = 100;
    final int HEIGHT = 100;

    char[][] grid = new char[WIDTH][HEIGHT];
    int pacmanX = WIDTH / 2;
    int pacmanY = HEIGHT / 2;
    int foodX, foodY;

    public Main_EX2_PM_3_2() {
        setPreferredSize(new Dimension(WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE));
        setBackground(Color.WHITE);
        placeWalls();
        placeFood();

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                movePacman(e.getKeyCode());
                repaint();
            }
        });
    }

    private void placeWalls() {
        for (int x = 0; x < WIDTH; x++) {
            grid[x][0] = '*';
            grid[x][HEIGHT - 1] = '*';
        }
        for (int y = 0; y < HEIGHT; y++) {
            grid[0][y] = '*';
            grid[WIDTH - 1][y] = '*';
        }
    }

    private void placeFood() {
        Random rand = new Random();
        do {
            foodX = rand.nextInt(WIDTH - 2) + 1;
            foodY = rand.nextInt(HEIGHT - 2) + 1;
        } while (grid[foodX][foodY] == '*');
    }

    private void movePacman(int keyCode) {
        int nextX = pacmanX;
        int nextY = pacmanY;

        if (keyCode == KeyEvent.VK_UP) nextY--;
        if (keyCode == KeyEvent.VK_DOWN) nextY++;
        if (keyCode == KeyEvent.VK_LEFT) nextX--;
        if (keyCode == KeyEvent.VK_RIGHT) nextX++;

        if (nextX >= 0 && nextX < WIDTH && nextY >= 0 && nextY < HEIGHT && grid[nextX][nextY] != '*') {
            pacmanX = nextX;
            pacmanY = nextY;
        }

        if (pacmanX == foodX && pacmanY == foodY) {
            placeFood();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                char c = grid[x][y];
                if (c == '*') {
                    g.setColor(Color.BLACK);
                    g.fillRect(x * CELL_SIZE, y * CELL_SIZE, 5, 5);
                }
            }
        }


        g.setColor(Color.RED);
        g.fillRect(foodX * CELL_SIZE, foodY * CELL_SIZE,5,5);


        g.setColor(Color.BLUE);
        g.fillRect(pacmanX * CELL_SIZE, pacmanY * CELL_SIZE, 5, 5);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pixel Pacman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Main_EX2_PM_3_2());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
