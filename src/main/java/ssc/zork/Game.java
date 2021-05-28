package ssc.zork;

import java.util.Scanner;

public class Game {
    public static void start(){
//        System.out.println("hello");
        Scanner sc= new Scanner(System.in);
        while(true) {
            System.out.print("Enter a command: ");
//            String what = sc.nextLine();
            CommandFactory commandFactory = new CommandFactory();
            Command command = commandFactory.createCommand(CommandParser.getCommand(sc.nextLine()));
            command.takeAction();
        }
    }
}
