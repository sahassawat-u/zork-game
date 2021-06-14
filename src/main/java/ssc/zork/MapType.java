package ssc.zork;

import ssc.zork.map.HauntedCastleMap;

public enum MapType {
    HAUNTED_CASTLE("HauntedCastle", HauntedCastleMap.class);
    //SILENT_FOREST("SilentForest", Sil);
    private String mapName;
    private Class className;
    MapType(String mapName,Class className){
        this.mapName = mapName;
        this.className = className;
    }

    public String getMapName() {
        return mapName;
    }

    public Class getClassName() {
        return className;
    }
}
