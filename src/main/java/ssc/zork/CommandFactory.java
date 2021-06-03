package ssc.zork;

import ssc.zork.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static Map<CommandType, Class> commandMap = new HashMap<>() {{
        CommandType[] commandTypes = CommandType.values();
        for (int i=0;i<commandTypes.length;i++) {
            put(commandTypes[i], commandTypes[i].getCommandClass());
        }
    }};

    public Command createCommand(CommandType commandType) {
        try {
            return (Command) commandMap.get(commandType).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("Unknown commandType");
    }
}
