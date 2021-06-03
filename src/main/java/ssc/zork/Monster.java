package ssc.zork;

import java.util.Random;

public class Monster {
    private static final int MIN_HEALTH = 25, MAX_HEALTH = 40;
    private static final int MIN_ATTACK = 20, MAX_ATTACK = 35;
    private int health, attack;
    private boolean aggro, isAlive;

    public Monster() {
        aggro = false;
        isAlive = true;
        health = (int) Math.floor(Math.random() * (MAX_HEALTH - MIN_HEALTH + 1) + MIN_HEALTH);;
        attack = (int) Math.floor(Math.random() * (MAX_ATTACK - MIN_ATTACK + 1) + MIN_ATTACK);
    }

    public boolean getAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setAggro(boolean aggro) {
        this.aggro = aggro;
    }

    public boolean getAggro() {
        return aggro;
    }

    public void getAttacked(Player player) {
        if (player.getShield() > 0) {
            player.reduceShield();
        } else {
            health -= player.attack();
        }
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        if (health < 0) setHealth(0);
        return health;
    }

    public int attack() {
        return attack;
    }
}
