package ssc.zork;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int MAX_HEALTH = 100;
    private int health,  x, y, shield;
    private Weapon weapon;
    private List<Item> items;
    private boolean isAlive;

    public Player(int xx, int yy) {
        shield = 0;
        health = 100;
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
        if(health<MAX_HEALTH)
            health += 15;
    }
    public void setShield() {
        if(shield<3)
            shield+=1;
    }
    public void reduceShield() {
        shield--;
    }
    public void setWeapon(){
        weapon = new Weapon();
    }
    public void PowerUp(){
        if(weapon!=null)
            weapon.upPower();
    }
    public int attack() {
        if(weapon!=null)
            return weapon.getPower();
        return 30;
    }
    public void drop(String itemName) {
        for (Item item:
             items) {
            if(item.getItemName().equals(itemName)){
                items.remove(item);break;
            }
        }
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
    }
    public void setPosition(boolean isY, int direction) {
        if(isY)x+=direction;
        else y+=direction;
    }
    public boolean getAlive() {
        return isAlive;
    }
    public int[] getPosition() {
        return new int[]{x,y};
    }
    public void addItem(Item item){
        items.add(item);
        if(item.getItemName().equals("Shield"))
            if(shield<3)shield++;
    }
}
