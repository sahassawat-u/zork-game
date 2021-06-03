package ssc.zork.command;

import ssc.zork.*;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class GoCommand implements Command {
    private static Scanner sc = new Scanner(System.in);

    @Override
    public void takeAction(MyMap map) {
        Room[][] rooms = map.getRooms();
        Player player = map.getPlayer();
        int[] position = player.getPosition();
        Room room = rooms[position[0]][position[1]];
        Set<String> directions = room.getDirectionList();
//        StringUtils.join(array, "");
        StringBuilder builder = new StringBuilder();
        for (String value : directions) {
            builder.append(value);
            builder.append(" ");
        }
        String text = builder.toString();
        System.out.println("direction: " + text);
        String direction = sc.nextLine();
        if (directions.contains(direction)) {
            map.setPlayer(direction);
            if (direction.equals("N")) {
                Room newRoom = rooms[position[0] - 1][position[1]];
                newRoom.playerEnter(player, map);
            } else if (direction.equals("S")) {
                Room newRoom = rooms[position[0] + 1][position[1]];
                newRoom.playerEnter(player, map);
            } else if (direction.equals("E")) {
                Room newRoom = rooms[position[0]][position[1] + 1];
                newRoom.playerEnter(player, map);
            } else if (direction.equals("W")) {
                Room newRoom = rooms[position[0]][position[1] - 1];
                newRoom.playerEnter(player, map);
            }
        } else {
            System.out.println("No room");
        }
    }

    @Override
    public void takeAction(MyMap map, String item, Monster monster) {

    }

    @Override
    public void takeAction(MyMap map, Monster monster) {

    }

    @Override
    public void takeAction(MyMap map, String direction) {
        Room[][] rooms = map.getRooms();
        Player player = map.getPlayer();
        int[] position = player.getPosition();
        Room room = rooms[position[0]][position[1]];
        Set<String> directions = room.getDirectionList();
        if (directions.contains(direction)) {
            map.setPlayer(direction);
            if (direction.equals("N")) {
                Room newRoom = rooms[position[0] - 1][position[1]];
                newRoom.playerEnter(player, map);
            } else if (direction.equals("S")) {
                Room newRoom = rooms[position[0] + 1][position[1]];
                newRoom.playerEnter(player, map);
            } else if (direction.equals("E")) {
                Room newRoom = rooms[position[0]][position[1] + 1];
                newRoom.playerEnter(player, map);
            } else if (direction.equals("W")) {
                Room newRoom = rooms[position[0]][position[1] - 1];
                newRoom.playerEnter(player, map);
            }
        } else {
            System.out.println("No room");
        }
    }
}
