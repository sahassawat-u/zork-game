package ssc.zork.command;

import ssc.zork.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveCommand implements Command {
    @Override
    public void takeAction(MyMap map) {

    }

    @Override
    public void takeAction(MyMap map, Monster monster) {

    }

    @Override
    public void takeAction(MyMap map, String item, Monster monster) {

    }

    @Override
    public void takeAction(MyMap map, String fileName) {
        try {
//            File file = new File(fileName + ".txt");
//            if (file.createNewFile()) {
//                System.out.println("File created: " + file.getName());
//            } else {
//                System.out.println("File already exists.");
//            }
//            FileWriter writer = new FileWriter(fileName+".txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt", true));
            writer.write("1");
            writer.newLine();
            Player player = map.getPlayer();
            Room[][] rooms = map.getRooms();
            for (int i = 0; i < rooms.length; i++) {
                String line = "";
                for (int j = 0; j < rooms[0].length; j++) {
                    if (rooms[i][j] != null)
                        line += rooms[i][j].getStatus() + " ";
                    else line += -1 + " ";
                }
                writer.write(line);
                writer.newLine();
            }
            writer.write(player.getPosition()[0] + "," + player.getPosition()[1]);
            writer.newLine();
            writer.write(player.getHealth() + "," + player.attack() + "," + player.getShield());
            writer.newLine();
            List<String> items = player.getItems();
            String itemsString = "";
            for (String item : items) {
                itemsString += item + ",";
            }
            writer.write(itemsString);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
