package exercises.ex4.E3_5;

public class Main_E3_5 {
    public static void main(String[] args) {
        CircuitTester f1 = new CircuitTester(1,1);

        System.out.println("1 : ");
        printStatus(f1,0);

        f1.toggleSecondSwitch();
        System.out.println("2 : ");
        printStatus(f1,1);

        f1.toggleFirstSwitch();
        System.out.println("3 : ");
        printStatus(f1,0);

        f1.toggleSecondSwitch();
        System.out.println("4 : ");
        printStatus(f1,1);
    }
    public static void printStatus(CircuitTester f , int second) {
        System.out.println("first switch : " + f.getFirstSwitchState());
        System.out.println("second switch : " + f.getSecondSwitchState());
        System.out.println("lamp state : " + f.getLampState());
        System.out.println("Expected lamp state : " + second);
        System.out.println();
    }
}
