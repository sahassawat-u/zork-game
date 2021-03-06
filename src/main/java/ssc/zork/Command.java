package ssc.zork;

import ssc.zork.creature.Monster;

public interface Command {
    void takeAction();
    void takeAction(MyMap map);
    void takeAction(MyMap map, Monster monster);
    void takeAction(MyMap map,String item);
    void takeAction(MyMap map,String item, Monster monster);
}
