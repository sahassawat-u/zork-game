package ssc.zork;

import java.util.Random;

public class Monster {
    private static final int min = 20,max = 35;
    private int health, attack;
    private boolean aggro,isAlive;
    public Monster(){
        aggro = false;
        isAlive = true;
        health = 30;
        attack = (int)Math.floor(Math.random()*(max-min+1)+min);
//        System.out.println(attack);
    }
//    public void battle(Player player) {
//        Scanner sc = new Scanner(System.in);
//        while(player.getHealth()>0 || getHealth() > 0) {
//            if(sc.nextLine().equals("attack")){
//        }
//    }
    public boolean getAlive(){
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setAggro(boolean aggro) {
        this.aggro = aggro;
    }
    public boolean getAggro(){
        return aggro;
    }
    public void getAttacked(Player player) {
        if(player.getShield()>0){
            player.reduceShield();
        }else {
            health -= player.attack();
        }
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        if(health<0) setHealth(0);
        return health;
    }

    public int attack() {
        return attack;
    }
}
