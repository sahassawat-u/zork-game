package ssc.zork;


public class CommandParser {
    public static CommandType getCommand(String command) {
        if(command.equals("info")) {
            return CommandType.INFO;
        } else if(command.equals("attack")) {
            return CommandType.ATTACK;
        } else if(command.equals("drop")) {
            return CommandType.DROP;
        } else if(command.equals("exit")) {
            return CommandType.EXIT;
        } else if(command.equals("go")) {
            return CommandType.GO;
        } else if(command.equals("load")) {
            return CommandType.LOAD;
        } else if(command.equals("map")) {
            return CommandType.MAP;
        } else if(command.equals("play")) {
            return CommandType.PLAY;
        } else if(command.equals("quit")) {
            return CommandType.QUIT;
        } else if(command.equals("save")) {
            return CommandType.SAVE;
        } else if(command.equals("take")) {
            return CommandType.TAKE;
        } else if(command.equals("autopilot")) {
            return CommandType.AUTOPILOT;
        }else
            return CommandType.ERROR;
    }
}
