package ssc.zork.command;

import ssc.zork.*;
import ssc.zork.creature.Monster;
import ssc.zork.creature.Player;

public class InfoCommand implements Command {
    @Override
    public void takeAction() {

    }

    @Override
    public void takeAction(MyMap map) {
        Player player = map.getPlayer();
        Room currentRoom = map.whereYouAre();
        System.out.println("\n---------Information---------");
        System.out.println("Player's HP ❤️: " + player.getHealth());
        System.out.println("Player's attack power ⚔️: " + player.getAttackPower());
        System.out.println("Player's shield: ️" + new String(new char[player.getShield()])
                .replace("\0", "\uD83D\uDEE1"));
        System.out.println("Player's items: " + player.getItems());
        if (!currentRoom.getTaken() && !currentRoom.getMonsterAlive())
            System.out.println("This room contains: " + currentRoom.getInfo());
        else
            System.out.println("This room contains: Nothing");
        System.out.println("-----------------------------\n");
    }

    @Override
    public void takeAction(MyMap map, Monster monster) {

    }

    @Override
    public void takeAction(MyMap map, String item, Monster monster) {

    }

    @Override
    public void takeAction(MyMap map, String item) {

    }
}
