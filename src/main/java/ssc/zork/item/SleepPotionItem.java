package ssc.zork.item;

import ssc.zork.Item;
import ssc.zork.creature.Monster;
import ssc.zork.creature.Player;

public class SleepPotionItem implements Item {

    @Override
    public void consume(Player player) {
    }

    @Override
    public void consume(Player player, Monster monster) {
        monster.setAggro(false);
        player.drop(getItemName());
    }
    @Override
    public String getItemName() {
        return "SleepingPotion";
    }
}
