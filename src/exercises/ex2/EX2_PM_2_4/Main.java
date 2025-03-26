package exercises.ex2.EX2_PM_2_4;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int k=9; //عدد مربوط به تمرین EX2_PM_1_1 و EX2_PM_1_2
        int c=15; //عدد مربوط به تمرین EX2_PM_1_3

        Random rnd = new Random();

        PacmanEngine pacmanEngine = new PacmanEngine(k,c);

        while(true) {
            pacmanEngine.printMatrix(); // مربوط به بخش آخر تمرین EX2_PM_1_3
            pacmanEngine.printScore(); // امتیاز تمرین EX2_PM_2_2
            pacmanEngine.printRemainTime(); // زمان تمرین EX2_PM_2_2

            try {
                Thread.sleep(2000);
            } catch (Exception e) {}

            int direction=rnd.nextInt(4);
            pacmanEngine.move(direction);// حرکت نقطه خوار مربوط به تمرین EX2-PM.1.5
            pacmanEngine.save();
        }

    }
}