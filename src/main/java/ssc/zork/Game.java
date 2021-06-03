package ssc.zork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Game {
    private static Scanner sc = new Scanner(System.in);
    private static String which;
    public static void start() {
        which = null;
        PrintInfo.printHeader();
        CommandFactory commandFactory = new CommandFactory();
        CommandParser commandParser = new CommandParser();
        while (true) {
            if(which==null) {
                PrintInfo.printStartingGame();
                which = sc.nextLine();
            }
            MyMap map = loadMap(which,commandFactory,commandParser);
            System.out.println("The object is to kill all monsters " +"("+map.getObjective()+")");
            which = gameLoop(map, commandFactory, commandParser);
        }
    }

    public static MyMap loadMap(String which,  CommandFactory commandFactory, CommandParser commandParser) {
        MyMap map = null;
        MapFactory mapFactory = new MapFactory();
        if(which.equals("exit")){
            Command command = commandFactory.createCommand(commandParser.getCommand(which));
            command.takeAction();
        }
        if (which.equals("1") || which.equals("HauntedCastle")) {
            System.out.println("Loading Haunted Castle...");
            map = mapFactory.createMap("HauntedCastle");
        } else if (which.equals("2") || which.equals("SilentForest")) {
            System.out.println("Loading Silent Forest...");
            map = mapFactory.createMap("SilentForest");
        }
        if (map == null) {
            String[] loadSaved = which.split(" ");
            if (loadSaved[0].equals("load")) {
                System.out.println("Loading saved map" + " (" + loadSaved[1] + ")");
                File savedMap = new File(loadSaved[1]);
                map = mapFactory.createMap(savedMap);
            } else System.out.println("An unsupported command");
        }
        return map;
    }

    public static String gameLoop(MyMap map, CommandFactory commandFactory, CommandParser commandParser) {
        while (!map.isFinished()) {
            if(!map.autoPilot()) {
                System.out.print("Decide your fate> ");
                String[] arguments = sc.nextLine().split(" ");
                Command command = commandFactory.createCommand(commandParser.getCommand(arguments[0]));
                if (arguments.length > 1) {
                    command.takeAction(map, arguments[1]);
                    if (map.isFinished()) {
                        if (arguments.length == 3) return arguments[1] + arguments[2];
                        if (arguments.length == 2) return arguments[1];
                    }
                } else {
                    command.takeAction(map);
                }
            } else {
                System.out.println("Autopilot starting...");
                try {
                    FileReader fr = new FileReader(map.getAutoFileName());
                    BufferedReader br = new BufferedReader(fr);
                    String line="";
                    while(line!=null){
                        line = br.readLine();
                        if(line!=null) {
                            String[] arguments = line.split(" ");
                            Command command = commandFactory.createCommand(commandParser.getCommand(arguments[0]));
                            if (arguments.length > 1) {
                                command.takeAction(map, arguments[1]);
                                if (map.isFinished()) {
                                    if (arguments.length == 3) return arguments[1] + arguments[2];
                                    if (arguments.length == 2) return arguments[1];
                                }
                            } else {
                                command.takeAction(map);
                            }
                        }
                    }
                    br.close();
                    map.setAutoPilot(false,"");
                    System.out.println("finished..");

                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        if(map.finishObjective())System.out.println("The objective accomplished!\n");
        else System.out.println("Create new game...\n");
        return null;
    }
}
