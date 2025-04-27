package exercises.ex4.E3_4;

public class Main_E3_4 {
    public static void main(String[] args) {
        functions f = new functions(1,1);
        if(f.getLampState() == 1){
            System.out.println("light is on");
        }else{
            System.out.println("light is off");
        }
        f.toggleFirstSwitch();
        if(f.getLampState() == 1){
            System.out.println("light is on");
        }else{
            System.out.println("light is off");
        }

    }
}
