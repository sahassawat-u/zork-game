package ssc.zork;

public enum InRoom {
    WEAPON(0.3,1),
    SHIELD(0.3,2),
    SLEEPINGPOTION(0.3,3),
    POWERUPITEM(0.4,4),
    NOTHING(0.3,5),
    MONSTER(0.3,0);

    private double probability;
    private int id;

    InRoom(double probability, int id) {
        this.probability = probability;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getProbability() {
        return probability;
    }
}
