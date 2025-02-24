import java.util.Scanner;

public class Gravity_calculation
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to ==> Gravity Calculation");

        //Gravitational acceleration constant.
        final double g = 9.8;

        // Scanning mass from the user.
        float m;
        System.out.print("Enter a number of mass:");
        Scanner mass = new Scanner(System.in);
        m = mass.nextFloat();

        // Scanning height from the user
        float h;
        System.out.print("Enter a number of height:");
        Scanner height = new Scanner(System.in);
        h = height.nextFloat();

        // print to terminal
        double Gravity = m*g*h;
        System.out.println("Gravity is : "+Gravity);
    }
}
