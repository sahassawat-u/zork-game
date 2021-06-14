package ssc.zork;

import ssc.zork.creature.Monster;
import ssc.zork.creature.Player;
import ssc.zork.room.InRoom;

import java.util.*;

public class Room {
    // accumulative probability
    private static final double WEAPON_PROBABILITY = InRoom.MONSTER.getProbability();
    private static final double ITEM_PROBABILITY = InRoom.SHIELD.getProbability();
    private static final double MONSTER_PROBABILITY = InRoom.MONSTER.getProbability();
    private Random random = new Random();
    private double prob, accumulativeProb;
    private Item item;
    private String info;
    private Weapon weapon;
    private InRoom status;
    private Monster monster;
    private boolean isVisited, isTaken, hasMonster;
    private Set<String> directionList;

    public Room() {
        accumulativeProb = 0.0;
        status = null;
        monster = null;
        prob = random.nextDouble();
        directionList = null;
        item = null;
        isVisited = false;
        isTaken = false;
        hasMonster = false;
        weapon = null;
        info = "";
    }

    public Room(Set<String> directions) {
        accumulativeProb = 0.0;
        status = InRoom.NOTHING;
        monster = null;
        prob = random.nextDouble();
        directionList = directions;
        item = null;
        isVisited = false;
        isTaken = false;
        hasMonster = false;
        weapon = null;
        info = "";
        if (prob < accumulateProbability(WEAPON_PROBABILITY)) {
            weapon = new Weapon();
            status = InRoom.WEAPON;
            return;
        }
        if (prob < accumulateProbability(ITEM_PROBABILITY)) {
            ItemFactory itemFactory = new ItemFactory();
            item = itemFactory.createItem();
            info = item.getItemName();
            if (info.equals("Shield")) {
                status = InRoom.SHIELD;
            } else if (info.equals("SleepingPotion")) {
                status = InRoom.SLEEPINGPOTION;
            } else if (info.equals("PowerUpItem")) {
                status = InRoom.POWERUPITEM;
            }
            return;
        }
        if (prob < accumulateProbability(MONSTER_PROBABILITY)) {
            monster = new Monster();
            status = InRoom.MONSTER;
            hasMonster = true;
            return;
        }
    }

    public double accumulateProbability(double thisProb) {
        this.accumulativeProb += thisProb;
        return accumulativeProb;
    }
    public boolean getMonsterAlive(){
        if(monster==null)return false;
        return monster.getAlive();
    }
    public void setStatus(InRoom inRoomType) {
        status = inRoomType;
        if (InRoom.WEAPON == inRoomType) {
            weapon = new Weapon();
        } else if (InRoom.SHIELD == inRoomType) {
            ItemFactory itemFactory = new ItemFactory();
            item = itemFactory.createItem("Shield");
        } else if (InRoom.SLEEPINGPOTION == inRoomType) {
            ItemFactory itemFactory = new ItemFactory();
            item = itemFactory.createItem("SleepingPotion");
        } else if (InRoom.POWERUPITEM == inRoomType) {
            ItemFactory itemFactory = new ItemFactory();
            item = itemFactory.createItem("PowerUpItem");
        } else if (InRoom.MONSTER == inRoomType) {
            monster = new Monster();
            hasMonster = true;
        }
    }
    public boolean getHasMonster(){
        return hasMonster;
    }
    public void setDirectionList(Set<String> directionList) {
        this.directionList = directionList;
    }

    public int getStatus() {
        return status.getId();
    }

    public Set<String> getDirectionList() {
        return directionList;
    }

    public Set<String> getDirection() {
        return directionList;
    }

    public void playerEnter(Player player, MyMap map) {
        player.regenHealth();
        if (status == InRoom.WEAPON) {
            System.out.println("You found an weapon");
            info = "weapon";
        } else if (status == InRoom.SHIELD || status == InRoom.SLEEPINGPOTION || status == InRoom.POWERUPITEM) {
            System.out.println("You found an item");
            info = item.getItemName();
        } else if (status == InRoom.MONSTER && monster.getAlive()) {
            info = "Monster\n";
            info += "Monster's Strength: " + monster.attack() + "\n";
            info += "Monster's HP: " + monster.getHealth();
            System.out.println("You found a monster");
            if(!map.autoPilot()) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Would you like to battle with ? [y/n]");
                String response = sc.nextLine();
                if (response.equals("y")) {
                    Battle.begin(player, monster, map);
                } else System.out.println("Ignore the battle");
            } else Battle.begin(player, monster, map);
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
