package ssc.zork;

import java.util.*;

public class Room {
    // accumulative probability
    private static final double WEAPON_PROBABILITY = -1;
    private static final double ITEM_PROBABILITY = 0.6;
    private static final double MONSTER_PROBABILITY = 1.;
    private Random random = new Random();
    private double prob;
    private Item item;
    private String info;
    private Weapon weapon;
    private InRoom status;
    private Monster monster;
    private boolean isVisited,isTaken,isMonsterDied;
    private Set<String> directionList;
    public Room() {
        status = null;
        monster = null;
        prob = random.nextDouble();
        directionList = null;
        item = null;
        isVisited = false;
        isTaken = false;
        isMonsterDied = false;
        weapon = null;
        info = "";
    }
    public Room(Set<String> directions) {
        status = InRoom.NOTHING;
        monster = null;
        prob = random.nextDouble();
        directionList = directions;
        item = null;
        isVisited = false;
        isTaken = false;
        isMonsterDied = false;
        weapon = null;
        info = "";
        if (prob < WEAPON_PROBABILITY) {
            weapon = new Weapon();
            status = InRoom.WEAPON;
        } else if (prob < ITEM_PROBABILITY) {
            ItemFactory itemFactory = new ItemFactory();
            item = itemFactory.createItem();
            info = item.getItemName();
            if(info.equals("Shield")) {
                status = InRoom.SHIELD;
            } else if(info.equals("SleepingPotion")) {
                status = InRoom.SLEEPINGPOTION;
            } else if(info.equals("PowerUpItem")) {
                status = InRoom.POWERUPITEM;
            }
        } else if (prob < MONSTER_PROBABILITY) {
            monster = new Monster();
            status = InRoom.MONSTER;
        }
    }
//    public void setId(int id) {
//        status = thisStatus;
//        if(thisStatus==1){
//            weapon = new Weapon();
//        }
//        else if(thisStatus==2){
//            ItemFactory itemFactory = new ItemFactory();
//            item = itemFactory.createItem("Shield");
//        }
//        else if(thisStatus==3){
//            ItemFactory itemFactory = new ItemFactory();
//            item = itemFactory.createItem("SleepingPotion");
//        }
//        else if(thisStatus==4){
//            ItemFactory itemFactory = new ItemFactory();
//            item = itemFactory.createItem("PowerUpItem");
//        } else if(thisStatus==5){
//            monster = new Monster();
//        }
//    }
    public void setStatus(InRoom inRoomType) {
        status = inRoomType;
        if(InRoom.WEAPON==inRoomType){
            weapon = new Weapon();
        }
        else if(InRoom.SHIELD==inRoomType){
            ItemFactory itemFactory = new ItemFactory();
            item = itemFactory.createItem("Shield");
        }
        else if(InRoom.SLEEPINGPOTION==inRoomType){
            ItemFactory itemFactory = new ItemFactory();
            item = itemFactory.createItem("SleepingPotion");
        }
        else if(InRoom.POWERUPITEM==inRoomType){
            ItemFactory itemFactory = new ItemFactory();
            item = itemFactory.createItem("PowerUpItem");
        } else if(InRoom.MONSTER==inRoomType){
            monster = new Monster();
        }
    }
    public void setDirectionList(Set<String> directionList) {
        this.directionList = directionList;
    }

    public InRoom getStatus() {
        return status;
    }

    public Set<String> getDirectionList() {
        return directionList;
    }

    public Set<String> getDirection() {
        return directionList;
    }
    public void playerEnter(Player player,MyMap map) {
        player.regenHealth();
        if (status==InRoom.WEAPON){
            System.out.println("You found an weapon");
            info="weapon";
        } else if (status==InRoom.SHIELD||status==InRoom.SLEEPINGPOTION||status==InRoom.POWERUPITEM) {
            System.out.println("You found an item");
            info=item.getItemName();
        } else if (status==InRoom.MONSTER && monster.getAlive()) {
            info="Monster\n";
            info+="Monster's Strength: " + monster.attack() + "\n";
            info+="Monster's HP: " + monster.getHealth();
            System.out.println("You found a monster");
            Scanner sc = new Scanner(System.in);
            System.out.println("Would you like to battle with ? [y/n]");
            String response = sc.nextLine();
            if (response.equals("y")) {
                Battle.begin(player, monster, map);
            } else System.out.println("Ignore the battle");
        } else {
            info = "nothing";
            System.out.println("Nothing in here");
        }

    }
    public void setItem(Item thisItem) {
        item = thisItem;
    }
    public void setWeapon(Weapon thisWeapon) {
        weapon = thisWeapon;
    }
    public boolean getMonsterAlive() {
        return isMonsterDied;
    }
    public void setMonsterAlive(boolean isDied) {
        isMonsterDied = isDied;
    }
    public String getInfo() {
        return info;
    }
    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
        status = InRoom.NOTHING;
    }
    public boolean getTaken() {
        return isTaken;
    }
    public boolean getVisited() {
        return isVisited;
    }
    public Item getItem() {
        return item;
    }

    public Weapon getWeapon() {
        return weapon;
    }
}
