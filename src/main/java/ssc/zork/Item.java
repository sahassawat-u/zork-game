package ssc.zork;

public interface Item {
    void consume(Player player);
    String getItemName();
}
