package ssc.zork;

import java.io.File;
import java.util.Scanner;

public class Game {
    private static Scanner sc = new Scanner(System.in);
    public static void start(){
        PrintInfo.printHeader();
        CommandFactory commandFactory = new CommandFactory();
        CommandParser commandParser = new CommandParser();
        while(true) {
            MyMap map = loadMap();
            gameLoop(map,commandFactory,commandParser);
            System.out.println("The goal accomplished!\n");
        }
    }
    public static MyMap loadMap(){
        MyMap map = null;
        PrintInfo.printStartingGame();
        String which = sc.nextLine();
        MapFactory mapFactory = new MapFactory();
        if(which.equals("1")) {
            System.out.println("Loading Haunted Castle...");
            map = mapFactory.createMap("Haunted Castle");
        }
        else if(which.equals("2")) {
            System.out.println("Loading Silent Forest...");
            map = mapFactory.createMap("Silent Forest");
        }
        if(map==null) {
            String[] loadSaved = which.split(" ");
            if (loadSaved[0].equals("load")) {
                System.out.println("Loading saved map" + " (" + loadSaved[1] + ")");
                File savedMap = new File(loadSaved[1]);
                map = mapFactory.createMap(savedMap);
            } else System.out.println("An unsupported command");
        }
        return map;
    }
    public static void gameLoop(MyMap map,CommandFactory commandFactory, CommandParser commandParser) {
        while (!map.isFinished()) {
            System.out.print("Decide your fate> ");
            String[] arguments = sc.nextLine().split(" ");
            Command command = commandFactory.createCommand(commandParser.getCommand(arguments[0]));
            if (arguments.length > 1) {
                command.takeAction(map, arguments[1]);
            } else {
                command.takeAction(map);
            }
        }
    }
}
