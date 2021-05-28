package ssc.zork.command;

import ssc.zork.Command;
import ssc.zork.Monster;
import ssc.zork.MyMap;

public class ErrorCommand implements Command {
    @Override
    public void takeAction(MyMap map) {
        System.out.println("Bad command");
    }
    @Override
    public void takeAction(MyMap map, Monster monster) {

    }
    @Override
    public void takeAction(MyMap map, String item) {

    }
}
