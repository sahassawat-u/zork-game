package ssc.zork;

public class Monster {
    int health, attack;
    public Monster(){
        health = 30;
        attack = 30;
    }
//    public void battle(Player player) {
//        Scanner sc = new Scanner(System.in);
//        while(player.getHealth()>0 || getHealth() > 0) {
//            if(sc.nextLine().equals("attack")){
//        }
//    }
    public void getAttacked(Player player) {
        if(player.getShield()>0){
            player.reduceShield();
        }else {
            health -= player.attack();
        }
    }
    public int getHealth() {
        return health;
    }

    public int attack() {
        return attack;
    }
}
