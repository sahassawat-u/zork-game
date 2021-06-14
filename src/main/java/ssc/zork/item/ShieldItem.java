package ssc.zork.item;

import ssc.zork.Item;
import ssc.zork.creature.Monster;
import ssc.zork.creature.Player;

public class ShieldItem implements Item {

    @Override
    public void consume(Player player) {
        player.addShield();
    }
    @Override
    public void consume(Player player, Monster monster) {
    }
    @Override
    public String getItemName() {
        return "Shield";
    }
}
