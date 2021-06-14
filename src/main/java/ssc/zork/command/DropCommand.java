package ssc.zork.command;

import ssc.zork.Command;
import ssc.zork.creature.Monster;
import ssc.zork.MyMap;
import ssc.zork.creature.Player;

public class DropCommand implements Command {
    @Override
    public void takeAction() {

    }

    @Override
    public void takeAction(MyMap map) {

    }

    @Override
    public void takeAction(MyMap map, Monster monster) {

    }

    @Override
    public void takeAction(MyMap map, String itemName) {
        Player player = map.getPlayer();
        if (itemName.equals("Shield")) player.reduceShield();
        else player.drop(itemName);
    }

    @Override
    public void takeAction(MyMap map, String item, Monster monster) {

    }
}
