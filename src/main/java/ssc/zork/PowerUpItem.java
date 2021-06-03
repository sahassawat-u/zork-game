package ssc.zork;

public class PowerUpItem implements Item {

    @Override
    public void consume(Player player) {
        player.decreaseHealth();
        player.PowerUp();
        player.drop(getItemName());
    }
    @Override
    public void consume(Player player,Monster monster) {
    }
    @Override
    public String getItemName() {
        return "PowerUpItem";
    }
}
