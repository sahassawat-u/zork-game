package ssc.zork;

public class PowerUpItem implements Item{
    @Override
    public void consume(Player player) {
        player.PowerUp();
    }

    @Override
    public String getItemName() {
        return "PowerUpItem";
    }
}
