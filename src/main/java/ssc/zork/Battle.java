package ssc.zork;

import java.util.Scanner;

public class Battle {
    public static void begin(Player player, Monster monster,MyMap map) {
        Scanner sc = new Scanner(System.in);
        while(player.getHealth()>0 && monster.getHealth() > 0) {
            CommandFactory commandFactory = new CommandFactory();
            Command command = commandFactory.createCommand(
                    CommandParser.getCommand(
                            sc.nextLine()));
            command.takeAction(map,monster);
        }
        if(player.getHealth()>0) {
            player.PowerUp();
        } else {
            System.out.println("You lost");
            map.quit();
        }
    }
}
