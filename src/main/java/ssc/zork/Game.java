package ssc.zork;

import ssc.zork.map.HauntedCastleMap;

import java.util.Scanner;

public class Game {
//    public MyMap map;
    public static void start(){
        PrintInfo.print();
        Scanner sc= new Scanner(System.in);
        MapFactory mapFactory = new MapFactory();
//        MyMap map = mapFactory.createMap("Haunted Castle");
//        map = mapFactory.createMap("Haunted Castle");
//        if(sc.nextLine().equals("1")){
//            if(sc.nextLine().equals("1")) {
//
//            } else {
//
//            }
//        } else if(sc.nextLine().equals("2")){
//
//        }
        while(true) {
            System.out.println("choose the map:");
            System.out.println("  (1) Haunted Castle/ (2) Silent Forest");
            System.out.println("or load your saved map");
//            System.out.println(sc.nextLine());
            String which = sc.nextLine();
            MyMap map = null;
            if(which.equals("1")) {
                System.out.println("Loading Haunted Castle...");
                map = mapFactory.createMap("Haunted Castle");
            }
            else if(which.equals("2")) {
                System.out.println("Loading Silent Forest...");
                map = mapFactory.createMap("Silent Forest");
            }
            while (!map.isFinished()) {
                System.out.print("Decide your fate: ");
                CommandFactory commandFactory = new CommandFactory();
                String[] arguments = sc.nextLine().split(" ");
                Command command = commandFactory.createCommand(
                        CommandParser.getCommand(
                                arguments[0]));
                if (arguments.length > 1) {
                    command.takeAction(map, arguments[1]);
                } else {
                    command.takeAction(map);
                }
            }
        }

    }
}
