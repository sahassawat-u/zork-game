package ssc.zork.command;

import ssc.zork.Command;

public class ExitCommand implements Command {
    @Override
    public void takeAction() {
        System.out.println("exit");
    }
}
