package ssc.zork;

public class Weapon {
    int power;
    public Weapon(){
        power = 20;
    }
//    public void upPower(){
//        power+=5;
//    }
    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
