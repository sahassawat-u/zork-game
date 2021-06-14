package ssc.zork.command;

import ssc.zork.Command;
import ssc.zork.creature.Monster;
import ssc.zork.MyMap;

public class AutoPilotCommand implements Command {
    @Override
    public void takeAction() {

    }

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
