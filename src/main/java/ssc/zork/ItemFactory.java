package ssc.zork;

import java.util.Random;

public class ItemFactory {
    private static final double POWERUP_PROBABILITY = InRoom.POWERUPITEM.getProbability();
    private static final double SLEEPPOTION_PROBABILITY = InRoom.SLEEPINGPOTION.getProbability();
    private static final double SHIELD_PROBABILITY = InRoom.SHIELD.getProbability();

    private Random random = new Random();
    private double accumulativeProb = 0.0;

    public Item createItem() {
        double prob = random.nextDouble();
        if (prob < accumulateProbability(POWERUP_PROBABILITY)) {
            return new PowerUpItem();
        }
        if (prob < accumulateProbability(SLEEPPOTION_PROBABILITY)) {
            return new SleepPotionItem();
        }
        if (prob < accumulateProbability(SHIELD_PROBABILITY)) {
            return new ShieldItem();
        }
        return null;
    }

    public double accumulateProbability(double thisProb) {
        this.accumulativeProb += thisProb;
        return accumulativeProb;
    }

    public Item createItem(String ItemName) {
        if (ItemName.equals("PowerUpItem")) {
            return new PowerUpItem();
        } else if (ItemName.equals("SleepingPotion")) {
            return new SleepPotionItem();
        } else if (ItemName.equals("Shield")) {
            return new ShieldItem();
        }
        return null;
    }
}
