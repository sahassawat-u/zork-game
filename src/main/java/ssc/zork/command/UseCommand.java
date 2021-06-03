package ssc.zork.command;

import ssc.zork.Command;
import ssc.zork.Monster;
import ssc.zork.MyMap;
import ssc.zork.Player;

public class UseCommand implements Command {
    @Override
    public void takeAction(MyMap map) {

    }

    @Override
    public void takeAction(MyMap map, Monster monster) {

    }

    @Override
    public void takeAction(MyMap map, String itemName) {
        Player player = map.getPlayer();
        if(player.hasThisItem(itemName) && itemName.equals("PowerUpItem")){
            System.out.println("Use PowerUp item");
            player.decreaseHealth();
            player.PowerUp();
            player.drop(itemName);
        } else if(player.hasThisItem(itemName) && itemName.equals("SleepingPotion")) {
            System.out.println("Cannot use outside of combat!");
            player.drop(itemName);
        }
    }

    @Override
    public void takeAction(MyMap map, String itemName, Monster monster) {
        Player player = map.getPlayer();
        if(player.hasThisItem(itemName) && itemName.equals("PowerUpItem")){
            System.out.println("Use PowerUp item");
            player.decreaseHealth();
            player.PowerUp();
            player.drop(itemName);
        } else if(player.hasThisItem(itemName) && itemName.equals("SleepingPotion")) {
            System.out.println("Use Sleeping potion");
            monster.setAggro(false);
            player.drop(itemName);
        } else {
            System.out.println("No such an item in your bag");
        }
    }
}
