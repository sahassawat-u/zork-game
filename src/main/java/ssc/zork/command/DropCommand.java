package ssc.zork.command;

import ssc.zork.Command;

public class DropCommand implements Command {
    @Override
    public void takeAction() {
        System.out.println("drop");
    }
}
