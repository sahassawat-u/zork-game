package ssc.zork.command;

import ssc.zork.*;

public class TakeCommand implements Command {
    @Override
    public void takeAction(MyMap map) {
        Player player = map.getPlayer();
        int[] position = player.getPosition();
        Room[][] rooms = map.getRooms();
        Room room = rooms[position[0]][position[1]];
        Item item = room.getItem();
        Weapon weapon =room.getWeapon();
        if(item!=null) {
            System.out.println("You take " + item.getItemName());
            player.addItem(item);
            room.setTaken(true);
        }
        else if(weapon!=null) {
            System.out.println("You take a weapon!");
            player.attachWeapon(weapon);
            room.setTaken(true);
        }
        else
            System.out.println("This room contains nothing");
    }
    @Override
    public void takeAction(MyMap map, Monster monster) {

    }
    @Override
    public void takeAction(MyMap map, String item) {

    }
}
