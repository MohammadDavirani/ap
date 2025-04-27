package exercises.ex4.E3_6;

public class Main_E3_6 {
    public static void main(String[] args) {
        functions f = new functions();
        f.getSwitchState(1);
        if(f.getLampState() == 0) {
            System.out.println("light is off");
        }
        else {
            System.out.println("light is on");
        }
        f.toggleSwitch(1);
        if(f.getLampState() == 0) {
            System.out.println("light is off");
        }
        else {
            System.out.println("light is on");
        }
    }
}
