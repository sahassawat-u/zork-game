package ssc.zork;


import ssc.zork.map.MapType;
//import ssc.zork.map.SilentForestMap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MapFactory {
    private static Map<String, Class> mapByName = new HashMap<>() {{
        MapType[] mapTypes = MapType.values();
        for (int i=0;i<mapTypes.length;i++) {
            put(mapTypes[i].getMapName(), mapTypes[i].getClassName());
        }
    }};
    private static Map<Integer, Class> mapByIndex = new HashMap<>() {{
        MapType[] mapTypes = MapType.values();
        for (int i=0;i<mapTypes.length;i++) {
            put(i+1, mapTypes[i].getClassName());
        }
    }};
    public MyMap createMap(String mapName) {
        try{
            return (MyMap) mapByName.get(mapName).newInstance();
        } catch (InstantiationException e){
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        }
        throw new IllegalArgumentException("Unknown Map");
    }
    public MyMap createMap(int mapId) {
        try{
            return (MyMap) mapByIndex.get(mapId).newInstance();
        } catch (InstantiationException e){
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        }
        throw new IllegalArgumentException("Unknown Map");
    }
    public MyMap createMap(File file) {
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            if (line.equals("1")) {
                return (MyMap) mapByIndex.get(Integer.parseInt(line)).newInstance();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e){
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        }
        throw new IllegalArgumentException("Unknown Map");
    }
}
