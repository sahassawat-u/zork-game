package ssc.zork.command;

import ssc.zork.Command;

public class ErrorCommand implements Command {
    @Override
    public void takeAction() {
        System.out.println("bad command");
    }
}
