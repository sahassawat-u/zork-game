package ssc.zork.command;

import ssc.zork.Command;
import ssc.zork.creature.Monster;
import ssc.zork.MyMap;
import ssc.zork.creature.Player;

public class AttackCommand implements Command {
    @Override
    public void takeAction() {

    }

    @Override
    public void takeAction(MyMap map) {
    }

    @Override
    public void takeAction(MyMap map, Monster monster) {
        Player player = map.getPlayer();
        monster.getAttacked(player);
        player.getAttacked(monster);
        System.out.println("------Status------");
        System.out.println("monster health " + monster.getHealth());
        System.out.println("player health " + player.getHealth());
        System.out.println("------------------");
    }

    @Override
    public void takeAction(MyMap map, String item) {

    }

    @Override
    public void takeAction(MyMap map, String item, Monster monster) {

    }
}
