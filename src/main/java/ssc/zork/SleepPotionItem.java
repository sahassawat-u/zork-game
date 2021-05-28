package ssc.zork;

public class SleepPotionItem implements Item{
    @Override
    public void consume(Player player) {
        System.out.println("sleep...");
    }

    @Override
    public String getItemName() {
        return "SleepingPotion";
    }
}
