package ssc.zork;

public interface Item {
    void consume(Player player);
    void consume(Player player,Monster monster);
    String getItemName();
}
