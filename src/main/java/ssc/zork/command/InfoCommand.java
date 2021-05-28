package ssc.zork.command;

import ssc.zork.*;

public class InfoCommand implements Command {
    @Override
    public void takeAction(MyMap map) {
        Player player = map.getPlayer();
        Room[][] rooms = map.getRooms();
        int[] position = player.getPosition();
        Room currentRoom = rooms[position[0]][position[1]];
        System.out.println("-------Information-------");
        System.out.println("Player's HP ❤️: "+player.getHealth());
        System.out.println("Player's attack power ⚔️: "+player.attack());
        System.out.println("Player's shield: ️"+ new String(new char[player.getShield()]).replace("\0", "\uD83D\uDEE1"));
        System.out.println("Player's items: "+ player.getItems());
        if(!currentRoom.getTaken()&&!currentRoom.getMonsterAlive())
            System.out.println("This room contains: "+currentRoom.getInfo());
        else
            System.out.println("This room contains: Nothing");
    }
    @Override
    public void takeAction(MyMap map, Monster monster) {

    }
    @Override
    public void takeAction(MyMap map, String item) {

    }
}
