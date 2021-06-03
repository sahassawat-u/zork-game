package ssc.zork;


import ssc.zork.map.HauntedCastleMap;
//import ssc.zork.map.SilentForestMap;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MapFactory {
    public MyMap createMap(String mapName) {
        if (mapName == "HauntedCastle") {
            return new HauntedCastleMap();
        }
//        else if (mapName == "SilentForest") {
////            return new SilentForestMap();
//        }
        return null;
    }

    public MyMap createMap(File file) {
        try {
            Scanner readFile = new Scanner(file);
            String data = readFile.nextLine();
            if (data.equals("1")) {
//                System.out.println("hi");
                return new HauntedCastleMap(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        if(mapName=="Haunted Castle") {
//            return new HauntedCastleMap();
//        }
        return null;
    }
}
