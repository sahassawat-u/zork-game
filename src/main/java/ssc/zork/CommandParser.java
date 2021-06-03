package ssc.zork;


import java.util.HashMap;
import java.util.Map;

public class CommandParser {
    private static Map<String, CommandType> commandMap = new HashMap<>() {{
        CommandType[] commandTypes = CommandType.values();
        for (int i=0;i<commandTypes.length;i++) {
            put(commandTypes[i].getCommandName(), commandTypes[i]);
        }
    }};
    public CommandType getCommand(String command) {
        if(!commandMap.containsKey(command))return CommandType.ERROR;
        return commandMap.get(command);
    }
}
