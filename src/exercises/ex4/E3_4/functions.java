package exercises.ex4.E3_4;

import java.util.Scanner;

public class functions {
    private int firstSwitch;
    private int secondSwitch;
    int lampState;

    public functions(){
        firstSwitch = 0;
        secondSwitch = 0;
    }

    public functions (int f , int s) {
        firstSwitch = f;
        secondSwitch = s;
    }

    public int getFirstSwitchState(){

        return firstSwitch;
    }

    public int getSecondSwitchState(){

        return secondSwitch;
    }

    public int getLampState(){
        if(firstSwitch == secondSwitch){
            lampState = 0;
        }else {
            lampState = 1;
        }
        return lampState;
    }

    public void toggleFirstSwitch() {
        if(firstSwitch == 1){
            firstSwitch = 0;
        }
        else {
            firstSwitch = 1;
        }
    }


    public void toggleSecondSwitch() {
        if(secondSwitch == 1){
            secondSwitch = 0;
        }
        else {
            secondSwitch = 1;
        }
    }
}
