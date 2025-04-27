package exercises.ex4.E3_6;

public class functions {
    private int[] switches;

    public functions() {
        switches = new int[2];
    }

    public int getSwitchState(int switchNum) {
        if(switchNum == 1 || switchNum == 2) {
            return switches[switchNum -1];
        }
        else {
            return -1;
        }
    }

    public int getLampState() {
        if(switches[0] == switches[1]) {
            return 0;
        }
        else {
            return 1;
        }
    }
    public void toggleSwitch(int switchNum) {
        if(switchNum == 1 || switchNum == 2) {
            switches[switchNum -1] = 1 - switches[switchNum -1];
        }
    }
}
