package ssc.zork.command;

import ssc.zork.Command;
import ssc.zork.creature.Monster;
import ssc.zork.MyMap;

public class ExitCommand implements Command {
    @Override
    public void takeAction() {
        System.exit(0);
    }

    @Override
    public void takeAction(MyMap map) {
    }

    @Override
    public void takeAction(MyMap map, Monster monster) {

    }

    @Override
    public void takeAction(MyMap map, String item) {

    }

    @Override
    public void takeAction(MyMap map, String item, Monster monster) {

    }
}
