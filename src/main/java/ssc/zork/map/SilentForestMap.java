package ssc.zork.map;

import ssc.zork.MyMap;
import ssc.zork.Player;
import ssc.zork.Room;

public class SilentForestMap implements MyMap {

    @Override
    public Room[][] createMap(String mapName) {
        return new Room[0][];
    }

    @Override
    public void printMap() {

    }
    @Override
    public void setPlayer(String direction){
//        return player;
    }
    @Override
    public Room[][] getRooms() {
        return new Room[0][];
    }@Override
    public Player getPlayer(){
        return null;
    }
    @Override
    public void quit() {
//        Room[][] rooms = new Room[rows][cols];
//        finished = true;
    }
    @Override
    public boolean isFinished() {
        return false;
//        Room[][] rooms = new Room[rows][cols];
//        finished = true;
    }
}