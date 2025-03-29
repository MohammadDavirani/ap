package exercises.ex2.EX2_PM_3_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class PacmanGUI extends JFrame implements KeyListener {

    Point pacmanPoint = new Point();
    final int width = 300, height = 300, boxSize = 5;
    static int direction = 1;
    final int LEFT = 1, RIGHT = 2, TOP = 3, BOTTOM = 4;
    Point dotPoint = new Point();
    static int score;
    long start;
    long elapsedTime;
    boolean Timing = false;

    public PacmanGUI() {
        addKeyListener(this);
        pacmanPoint.setLocation((width / boxSize) / 2, (height / boxSize) / 2);
        getNewDotPointLocation();
        setSize(width, height);
    }

    @Override
    public void paint(Graphics g) {
        if (Timing) {
            elapsedTime = (System.currentTimeMillis() - start) / 1000;
        }

        Graphics2D g2D = (Graphics2D) g;
        g.clearRect(0, 0, width, height);
        logic();
        drawPacman(g2D);
        drawDotPoint(g2D);
        drawScore(g2D);
        setVisible(true);
    }

    private void drawPacman(Graphics2D g2d) {
        if(score <3 && elapsedTime <15) {
            g2d.setColor(Color.BLUE);
            g2d.fillRect(pacmanPoint.x * boxSize, pacmanPoint.y * boxSize, boxSize, boxSize);
        }
    }

    private void drawDotPoint(Graphics2D g2d) {
        if(score <3 && elapsedTime <15) {
            g2d.setColor(Color.RED);
            g2d.fillRect(dotPoint.x * boxSize, dotPoint.y * boxSize, boxSize, boxSize);
            if(pacmanPoint.x ==dotPoint.x && pacmanPoint.y == dotPoint.y) {
                score++;
                System.out.println("Score: "+ score);
            }
        }
        if(score == 3) {
            g2d.setColor(Color.green);
            String s = String.format("Game Over.");
            g2d.drawString(s, 100, 150);
        }
        if(elapsedTime == 15) {
            g2d.setColor(Color.red);
            String s = String.format("Time is done.");
            g2d.drawString(s, 100, 150);
            System.exit(0);
        }
    }

    private void drawScore(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        String s = String.format("Score: %d",score);
        g2d.drawString(s, 150, 50);

        String s2 = String.format("Max Score: 3");
        g2d.drawString(s2, 25, 50);

        String s3 = String.format("timeElapsed: %ds",elapsedTime);
        g2d.drawString(s3,150,65);

        String s4 = String.format("Max Time: 15s");
        g2d.drawString(s4, 25, 65);


    }

    private void logic() {
        if (dotPoint.x == pacmanPoint.x && dotPoint.y == pacmanPoint.y) {
            getNewDotPointLocation();
        }
        movePacman();
    }

    private void movePacman() {
        int xMovement = 1;
        int yMovement = 0;
        switch (direction) {
            case LEFT:
                xMovement = -1;
                yMovement = 0;
                break;
            case RIGHT:
                xMovement = 1;
                yMovement = 0;
                break;
            case TOP:
                xMovement = 0;
                yMovement = -1;
                break;
            case BOTTOM:
                xMovement = 0;
                yMovement = 1;
                break;
            default:
                xMovement = yMovement = 0;
                break;
        }
        pacmanPoint.setLocation(pacmanPoint.x + xMovement, pacmanPoint.y + yMovement);
        handleCrossBorder();
    }

    private void getNewDotPointLocation() {
        Random rand = new Random();
        int delta = boxSize * 2;
        dotPoint.setLocation(rand.nextInt(width / boxSize - 2 * delta) + delta, rand.nextInt(height / boxSize - 2 * delta) + delta);
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!Timing) {
            start = System.currentTimeMillis();
            Timing = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP)
            direction = 3;
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
            direction = 4;
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
            direction = 1;
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            direction = 2;
        else if (e.getKeyCode() == KeyEvent.VK_P)
            direction = 0;
        else if(e.getKeyCode() == KeyEvent.VK_Q) {
            System.exit(0);
        }
        else
            direction = -1;

        System.out.println("direction:" + direction + "    <- e.getKeyCode()=" + e.getKeyCode());

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private void handleCrossBorder() {
        int maxX_R = (width / boxSize) - 3;
        int maxY_R = (height / boxSize) - 3;

        if (pacmanPoint.x < 0) {
            pacmanPoint.x = 2;
        } else if (pacmanPoint.x > maxX_R) {
            pacmanPoint.x = maxX_R;
        }

        if (pacmanPoint.y < 0) {
            pacmanPoint.y = 2;
        } else if (pacmanPoint.y > maxY_R) {
            pacmanPoint.y = maxY_R;
        }
    }


    public static void main(String[] args) {
        PacmanGUI frame = new PacmanGUI();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
