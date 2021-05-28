package ssc.zork;

public class ShieldItem implements Item{
    @Override
    public void consume(Player player) {
        player.setShield();
    }
    @Override
    public String getItemName() {
        return "Shield";
    }
}
