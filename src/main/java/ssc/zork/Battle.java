package ssc.zork;

import java.util.Scanner;

public class Battle {
    public static void begin(Player player, Monster monster,MyMap map) {
        Scanner sc = new Scanner(System.in);
        CommandParser commandParser = new CommandParser();
        CommandFactory commandFactory = new CommandFactory();
        System.out.println("Battle begun!");
        if(monster.getHealth() > 0){
            monster.setAggro(true);
            while(monster.getAggro() && player.getHealth()>0 && monster.getHealth() > 0) {
                System.out.print("choose action> ");
                String[] arguments = sc.nextLine().split(" ");
                Command command = commandFactory.createCommand(
                        commandParser.getCommand(
                                arguments[0]));
                if (arguments.length > 1) {
                    command.takeAction(map, arguments[1],monster);
                } else {
                    command.takeAction(map,monster);
                }
            }
            if(!monster.getAggro())System.out.println("Run away from monster");
            else if(player.getHealth()>0) {
                System.out.println("Monster Killed!");
                System.out.println("Exit the battle\n");
                monster.setAlive(false);
                player.PowerUp();
            } else {
                System.out.println("You lost!");
                map.quit();
            }
        }
    }
}
