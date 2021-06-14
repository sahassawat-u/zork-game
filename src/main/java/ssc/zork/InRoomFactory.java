package ssc.zork;

import ssc.zork.room.InRoom;

import java.util.HashMap;
import java.util.Map;

public class InRoomFactory {
    private static Map<Integer, InRoom> inRoomMap = new HashMap<>() {{
        InRoom[] inRoom = InRoom.values();
        for (int i=0;i<inRoom.length;i++) {
            put(i, inRoom[i]);
        }
    }};
    public InRoom createInRoom(int id) {
       return inRoomMap.get(id);
    }
}
