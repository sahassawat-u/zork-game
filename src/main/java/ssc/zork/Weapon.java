package ssc.zork;

public class Weapon {
    int power;
    public Weapon(){
        power = 50;
    }
    public void upPower(){
        power+=5;
    }

    public int getPower() {
        return power;
    }
}
