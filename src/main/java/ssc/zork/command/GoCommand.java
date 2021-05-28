package ssc.zork.command;

import ssc.zork.*;

import java.util.Scanner;
import java.util.Set;

public class GoCommand implements Command {
    @Override
    public void takeAction(MyMap map) {
        Scanner sc = new Scanner(System.in);
        Room[][] rooms = map.getRooms();
        Player player = map.getPlayer();
        int[] position = player.getPosition();
        Set<String> directions = rooms[position[0]][position[1]].directionList;
        System.out.println(directions);
        String direction = sc.nextLine();
        if(directions.contains(direction)){
            map.setPlayer(direction);
//            System.out.println(position[0] + " " + position[1]);
            if(direction.equals("N")) {
//                System.out.println((position[0]-1) + " " + position[1]);
                rooms[position[0]-1][position[1]].playerEnter(player, map);
            }
            else if(direction.equals("S")) {
//                System.out.println((position[0]+1) + " " + position[1]);
                rooms[position[0]+1][position[1]].playerEnter(player, map);
            } else if(direction.equals("E")) {
//                System.out.println(position[0] + " " + (position[1]+1));
                rooms[position[0]][position[1]+1].playerEnter(player, map);
            } else if(direction.equals("W")) {
//                System.out.println(position[0] + " " + (position[1]-1));
                rooms[position[0]][position[1]-1].playerEnter(player, map);
            }
        }
//        System.out.println("This room contains " + rooms[position[0]][position[1]].getWhatsinside());

//        switch (rooms[position[0]][position[1]].getWhatsinside()){
//            case ITEM:{
//                ItemFactory itemFactory = new ItemFactory();
//                System.out.println("This can be picked up");
//                player.addItem(itemFactory.createItem()); }
//            case MONSTER:{
//                System.out.println("Would you like to battle with ? [y/n]");
//                String response = sc.nextLine();
//                if(response.equals("y")){
//                    Monster monster = new Monster();
//                }
//            }case WEAPON:{
//
//            } default:
//                System.out.println("Nothing here");
//        }
    }

    @Override
    public void takeAction(MyMap map, Monster monster) {

    }
    @Override
    public void takeAction(MyMap map, String item) {

    }
}
