package ssc.zork;

import java.util.ArrayList;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;

public class Player {
    private static final int MAX_HEALTH = 100;
    private static final int MAX_POWER = 50;
    private int health,  x, y, shield, attackPower;
    private Weapon weapon;
    private List<Item> items;
    private boolean isAlive;

    public Player(int xx, int yy) {
        shield = 0;
        health = 100;
        attackPower = 25;
        x = xx;
        y = yy;
//        position = new Position(x,y);
        weapon = null;
        items = new ArrayList<>();

        isAlive = true;
    }
    public void setAlive() {
        if(health<=0){
            isAlive = false;
        }
    }
    public int getShield(){
        return shield;
    }
    public int getHealth(){
        return health;
    }
    public void regenHealth(){
        if(health+10<=MAX_HEALTH)
            health += 10;
        else health = MAX_HEALTH;
    }
    public void setShield() {
        if(shield<3)
            shield+=1;
    }
//    public Weapon getWeapon(){return this.weapon;}
    public void reduceShield() {
        System.out.println("Shield consumed");
        shield--;
    }
    public void decreaseHealth(){
        health-=20;
    }
    public void setWeapon(){
        weapon = new Weapon();
    }
    public void PowerUp(){
        if(attackPower<50)attackPower+=5;
    }
    public void setShield(int thisShield){
        shield = thisShield;
    }
    public void setPower(int thisPower){
        if(weapon==null)weapon = new Weapon();
        weapon.setPower(thisPower);
    }
    public void setHealth(int thisHealth){
        health = thisHealth;
    }
    public void setItems(List<String> thisItems){
        List<Item> tmpItems = new ArrayList<>();
        ItemFactory itemFactory = new ItemFactory();
        for(String item : thisItems){
            tmpItems.add(itemFactory.createItem(item));
        }
        items = tmpItems;
    }
    public int attack() {
        return attackPower;
    }
    public int getAttackPower() {
        return attackPower;
    }
    public void drop(String itemName) {
        for (Item item:
             items) {
            if(item.getItemName().equals(itemName)){
                items.remove(item);break;
            }
        }
    }
    public void setItem(Item thisItem){

    }
    public List<String> getItems() {
        List<String> res = new ArrayList<>();
        for(Item item: items) {
            res.add(item.getItemName());
        }
        return res;
    }
    public void getAttacked(Monster monster) {
        health-=monster.attack();
    }
    public void attachWeapon(Weapon foundWeapon) {
        weapon = foundWeapon;
        attackPower += weapon.getPower();
    }
    public void setPosition(boolean isY, int direction) {
        if(isY)x+=direction;
        else y+=direction;
    }
    public boolean hasThisItem(String itemName){
        for (Item item:
                this.items) {
            if(item.getItemName().equals(itemName)){
                return true;
            }
        }
        return false;
    }
    public boolean getAlive() {
        return isAlive;
    }
    public int[] getPosition() {
        return new int[]{x,y};
    }
    public void addItem(Item item){
        if(item.getItemName().equals("Shield")) {
            if (shield < 3) shield++;
            return;
        }
        items.add(item);
    }
}
