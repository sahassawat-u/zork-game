package ssc.zork.command;

import ssc.zork.Command;
import ssc.zork.Monster;
import ssc.zork.MyMap;

public class HelpCommand implements Command {
    @Override
    public void takeAction(MyMap map) {
        System.out.println("info - print out information of the player and the room that the player ");
        System.out.println("take – take command is used to pick up the item in the current room");
        System.out.println("drop – drop item of choice that the player currently carries");
        System.out.println("attack – is used to attack a monster in the current room");
        System.out.println("go – move player to the room as specified by the direction");
        System.out.println("map – print 2D map using ascii art");
        System.out.println("autopilot {file} – run this game in autopilot mode");
        System.out.println("quit – end the current game and return to command prompt");
        System.out.println("play {map-name} – play new game");
        System.out.println("load {saved-point-name} – load game state from saved point");
        System.out.println("save {saved-point-name}");
        System.out.println("exit – exit whole game");
    }

    @Override
    public void takeAction(MyMap map, Monster monster) {

    }
    @Override
    public void takeAction(MyMap map, String item) {

    }
}
