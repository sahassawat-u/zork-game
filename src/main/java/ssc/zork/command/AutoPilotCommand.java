package ssc.zork.command;

import ssc.zork.Command;
import ssc.zork.Monster;
import ssc.zork.MyMap;

import java.io.File;

public class AutoPilotCommand implements Command {
    @Override
    public void takeAction(MyMap map) {

    }

    @Override
    public void takeAction(MyMap map, Monster monster) {

    }

    @Override
    public void takeAction(MyMap map, String fileName) {
        map.setAutoPilot(true,fileName);
    }

    @Override
    public void takeAction(MyMap map, String item, Monster monster) {

    }
}
