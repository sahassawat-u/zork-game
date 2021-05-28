package ssc.zork.command;

import ssc.zork.Command;

public class AutoPilotCommand implements Command {
    @Override
    public void takeAction() {
        System.out.println("autopilot");
    }
}
