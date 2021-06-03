package ssc.zork.command;

import ssc.zork.*;

public class TakeCommand implements Command {
    @Override
    public void takeAction(MyMap map) {
        Room room = map.whereYouAre();
        Item item = room.getItem();
        Weapon weapon =room.getWeapon();
        if(item!=null) {
            System.out.println("Take " + item.getItemName());
            map.getPlayer().addItem(item);
            room.setItem(null);
            room.setTaken(true);
        }
        else if(weapon!=null) {
            if(map.getPlayer().attack()<50) {
                System.out.println("Take a weapon!");
                System.out.println("Attack Power + 20");
                room.setWeapon(null);
                map.getPlayer().attachWeapon(weapon);
                room.setTaken(true);
            } else System.out.println("Current weapon has the same stat");
        }
        else
            System.out.println("This room contains nothing");
    }
    @Override
    public void takeAction(MyMap map, Monster monster) {

    }
    @Override
    public void takeAction(MyMap map, String item, Monster monster) {

    }
    @Override
    public void takeAction(MyMap map, String item) {

    }
}
