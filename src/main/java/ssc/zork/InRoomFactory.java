package ssc.zork;

import java.util.HashMap;
import java.util.Map;

public class InRoomFactory {
    private static Map<Integer, InRoom> inRoomMap = new HashMap<>() {{
        InRoom[] inRoom = InRoom.values();
        for (int i=1;i<=inRoom.length;i++) {
            put(i, inRoom[i]);
        }
    }};
    public InRoom createInRoom(int id) {
       return inRoomMap.get(id);
    }
}
