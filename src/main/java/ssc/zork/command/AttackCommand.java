package ssc.zork.command;

import ssc.zork.Command;

public class AttackCommand implements Command {
    @Override
    public void takeAction() {
        System.out.println("attack");
    }
}
