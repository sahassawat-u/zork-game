package ssc.zork;

import ssc.zork.command.*;

import java.awt.*;

public enum CommandType {
    INFO(InfoCommand.class,"info"),
    TAKE(TakeCommand.class,"take"),
    DROP(DropCommand.class,"drop"),
    ATTACK(AttackCommand.class,"attack"),
    GO(GoCommand.class,"go"),
    MAP(MapCommand.class,"map"),
    AUTOPILOT(AutoPilotCommand.class,"autopilot"),
    HELP(HelpCommand.class,"help"),
    QUIT(QuitCommand.class,"quit"),
    PLAY(PlayCommand.class,"play"),
    LOAD(LoadCommand.class,"load"),
    SAVE(SaveCommand.class,"save"),
    EXIT(ExitCommand.class,"exit"),
    ERROR(ErrorCommand.class,"error"),
    USE(UseCommand.class,"use");
    private Class commandClass;
    private String commandName;
    public Class getCommandClass() {
        return commandClass;
    }
    public String getCommandName()  {return commandName;}
    CommandType(Class commandClass,String commandName) {
        this.commandClass = commandClass;
        this.commandName = commandName;
    }
}
