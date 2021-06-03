package ssc.zork.command;

import ssc.zork.*;

public class UseCommand implements Command {
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
        if (player.hasThisItem(itemName) && itemName.equals("PowerUpItem")) {
            System.out.println("Use PowerUp item");
            Item item = player.getItem(itemName);
            item.consume(player);
        } else if (player.hasThisItem(itemName) && itemName.equals("SleepingPotion")) {
            System.out.println("Cannot use outside of combat!");
        } else {
            System.out.println("No such an item in your bag");
        }
    }

    @Override
    public void takeAction(MyMap map, String itemName, Monster monster) {
        Player player = map.getPlayer();
        if (player.hasThisItem(itemName) && itemName.equals("PowerUpItem")) {
            System.out.println("Use PowerUp item");
            Item item = player.getItem(itemName);
            item.consume(player);
        } else if (player.hasThisItem(itemName) && itemName.equals("SleepingPotion")) {
            System.out.println("Use Sleeping potion");
            Item item = player.getItem(itemName);
            item.consume(player, monster);
        } else {
            System.out.println("No such an item in your bag");
        }
    }
}
