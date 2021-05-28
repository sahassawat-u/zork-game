package ssc.zork;

import java.util.ArrayList;
import java.util.List;

public interface MyMap {
    Room[][] createMap(String mapName);
    void printMap();
    Room[][] getRooms();
    Player getPlayer();
    void setPlayer(String direction);
    void quit();
    boolean isFinished();
}
