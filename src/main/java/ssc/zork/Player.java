package ssc.zork;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int MAX_HEALTH = 100;
    private static final int MAX_POWER = 50;
    private int health, x, y, shield, attackPower, monsterKilled;
    private Weapon weapon;
    private List<Item> items;
    private boolean isAlive;

    public Player(int xx, int yy) {
        shield = 0;
        health = 100;
        attackPower = 25;
        x = xx;
        y = yy;
        monsterKilled = 0;
        weapon = null;
        items = new ArrayList<>();
        isAlive = true;
    }

    public void setAlive() {
        if (health <= 0) {
            isAlive = false;
        }
    }
    public void upScore(){
        monsterKilled++;
    }
    public int getProgression(){
        return monsterKilled;
    }
    public int getShield() {
        return shield;
    }

    public int getHealth() {
        return health;
    }

    public void regenHealth() {
        if (health + 10 <= MAX_HEALTH)
            health += 10;
        else health = MAX_HEALTH;
    }

    public void addShield() {
        if (shield < 3)
            shield += 1;
    }

    public void reduceShield() {
        System.out.println("Shield consumed");
        shield--;
    }

    public void decreaseHealth() {
        health -= 20;
    }

    public void setWeapon() {
        weapon = new Weapon();
    }

    public void PowerUp() {
        if (attackPower < 50) attackPower += 5;
    }

    public void setPower(int thisPower) {
        attackPower = thisPower;
//        if (weapon == null) weapon = new Weapon();
//        weapon.setPower(thisPower);
    }

    public void setHealth(int thisHealth) {
        health = thisHealth;
    }

    public void setItems(List<String> thisItems) {
        List<Item> tmpItems = new ArrayList<>();
        ItemFactory itemFactory = new ItemFactory();
        for (String item : thisItems) {
            tmpItems.add(itemFactory.createItem(item));
        }
        items = tmpItems;
    }
    public Item getItem(String itemName) {
        ItemFactory itemFactory = new ItemFactory();
        for (Item item : items) {
            if(item.getItemName().equals(itemName))return item;
        }
        return null;
    }
    public int attack() {
        return attackPower;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void drop(String itemName) {
        for (Item item :
                items) {
            if (item.getItemName().equals(itemName)) {
                items.remove(item);
                break;
            }
        }
    }

//    public void setItem(Item thisItem) {
//
//    }

    public List<String> getItems() {
        List<String> res = new ArrayList<>();
        for (Item item : items) {
            res.add(item.getItemName());
        }
        return res;
    }

    public void getAttacked(Monster monster) {
        if(shield>0){reduceShield();return;}
        health -= monster.attack();
    }

    public void attachWeapon(Weapon foundWeapon) {
        weapon = foundWeapon;
        if (attackPower + weapon.getPower() <= 50) {
            System.out.println("Take a weapon!");
            System.out.println("Attack Power + 20");
            attackPower += weapon.getPower();
        } else {
            attackPower = 50;
            System.out.println("Current attack stat is at max!");
        }
    }
    public void setShield(int shield) {
        this.shield = shield;
    }

    public void setPosition(boolean isY, int direction) {
        if (isY) x += direction;
        else y += direction;
    }

    public boolean hasThisItem(String itemName) {
        for (Item item :
                this.items) {
            if (item.getItemName().equals(itemName)) {
                return true;
            }
        }
        return false;
    }

    public boolean getAlive() {
        return isAlive;
    }

    public int[] getPosition() {
        return new int[]{x, y};
    }

    public void addItem(Item item) {
        if (item.getItemName().equals("Shield")) {
            item.consume(this);
            return;
        }
        items.add(item);
    }
}
