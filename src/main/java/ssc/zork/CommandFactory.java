package ssc.zork;

import ssc.zork.command.*;

public class CommandFactory {
    public Command createCommand(CommandType commandType) {
        switch (commandType) {
            case ATTACK:
               return new AttackCommand();
            case AUTOPILOT:
                return new AutoPilotCommand();
            case DROP:
                return new DropCommand();
            case EXIT:
                return new ExitCommand();
            case GO:
                return new GoCommand();
            case HELP:
                return new HelpCommand();
            case INFO:
                return new InfoCommand();
            case LOAD:
                return new LoadCommand();
            case MAP:
                return new MapCommand();
            case PLAY:
                return new PlayCommand();
            case QUIT:
                return new QuitCommand();
            case SAVE:
                return new SaveCommand();
            case TAKE:
                return new TakeCommand();
            case ERROR:
                return new ErrorCommand();
            default:
                return null;
        }
    }
}
