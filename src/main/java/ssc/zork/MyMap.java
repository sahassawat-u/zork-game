package ssc.zork;

import ssc.zork.creature.Player;

public interface MyMap {
    Room[][] createMap(String mapName);
    void printMap();
    Room[][] getRooms();
    Player getPlayer();
    void setPlayer(String direction);
    void quit();
    boolean isFinished();
    Room whereYouAre();
    int getObjective();
    boolean finishObjective();
    boolean autoPilot();
    void setAutoPilot(boolean isAuto, String fileName);
    String getAutoFileName();
}
