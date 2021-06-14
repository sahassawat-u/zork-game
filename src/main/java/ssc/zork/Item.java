package ssc.zork;

import ssc.zork.creature.Monster;
import ssc.zork.creature.Player;

public interface Item {
    void consume(Player player);
    void consume(Player player, Monster monster);
    String getItemName();
}
