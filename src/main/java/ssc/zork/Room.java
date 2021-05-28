package ssc.zork;

import java.util.*;

public class Room {
    // accumulative probability
    private static final double WEAPON_PROBABILITY = 0.25;
    private static final double ITEM_PROBABILITY = 0.5;
    private static final double MONSTER_PROBABILITY = 0.7;
    private Random random = new Random();
    private double prob;
    private WhatsInside whatsinside;
    private Item item;
    private String info;
    private Weapon weapon;
    private boolean isVisited,isTaken,isMonsterDied;
    public Set<String> directionList;
    public Room(Set<String> directions) {
        prob = random.nextDouble();
        directionList = directions;
        item = null;
        isVisited = false;
        isTaken = false;
        isMonsterDied = false;
        weapon = null;
        info = "";
    }
    public Set<String> getDirection() {
        return directionList;
    }
    public void playerEnter(Player player,MyMap map) {
//        System.out.println(isVisited);
        player.regenHealth();
        if(!isVisited) {
            isVisited = true;
            if (prob < WEAPON_PROBABILITY) {
                System.out.println("You found an weapon");
                info="weapon";
                weapon = new Weapon();
            } else if (prob < ITEM_PROBABILITY) {
                System.out.println("You found an item");

                ItemFactory itemFactory = new ItemFactory();
                item = itemFactory.createItem();
                info=item.getItemName();
//            player.addItem(itemFactory.createItem());
            } else if (prob < MONSTER_PROBABILITY) {
//            Battle battle = new Battle();
                info="Monster\n";
                Monster monster = new Monster();
                info+="Monster Strength " + monster.attack() + "\n";
                info+="Monster HP " + monster.getHealth() + "\n";
                System.out.println("You found a monster");
                Scanner sc = new Scanner(System.in);
                System.out.println("Would you like to battle with ? [y/n]");
                String response = sc.nextLine();
                if (response.equals("y")) {
                    Battle.begin(player, monster, map);
                }
            } else {
                info = "nothing";
                System.out.println("Nothing in here");
            }
        } else {
            info = "nothing";
        }

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
