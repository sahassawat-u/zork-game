package ssc.zork;

public class ShieldItem implements Item {

    @Override
    public void consume(Player player) {
        player.addShield();
    }
    @Override
    public void consume(Player player,Monster monster) {
    }
    @Override
    public String getItemName() {
        return "Shield";
    }
}
