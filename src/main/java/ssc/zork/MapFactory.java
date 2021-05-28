package ssc.zork;


import ssc.zork.map.HauntedCastleMap;

public class MapFactory {
    public MyMap createMap(String mapName) {
        if(mapName=="Haunted Castle") {
            return new HauntedCastleMap();
        }
        return null;
    }
}
