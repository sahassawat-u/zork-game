package ssc.zork;

import java.util.Random;

public class ItemFactory {
    private static final double POWERUP_PROBABILITY = 0.3;
    private static final double SLEEPPOTION_PROBABILITY = 0.6;
    private static final double SHIELD_PROBABILITY = 1;

    private Random random = new Random();
    public Item createItem(){
        double prob = random.nextDouble();
        if(prob<POWERUP_PROBABILITY){
            return new PowerUpItem();
        }
        else if(prob<SLEEPPOTION_PROBABILITY){
            return new SleepPotionItem();
        } else if(prob<SHIELD_PROBABILITY){
            return new ShieldItem();
        }
        return null;
    }
}
