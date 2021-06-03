package ssc.zork.command;

import ssc.zork.Command;
import ssc.zork.Monster;
import ssc.zork.MyMap;

public class QuitCommand implements Command {

    @Override
    public void takeAction(MyMap map, Monster monster) {
    }
    @Override
    public void takeAction(MyMap map, String item, Monster monster) {

    }
    @Override
    public void takeAction(MyMap map) {
        map.quit();
    }
    @Override
    public void takeAction(MyMap map, String item) {

    }
}
