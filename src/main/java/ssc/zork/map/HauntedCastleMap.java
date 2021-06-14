package ssc.zork.map;

import ssc.zork.InRoomFactory;
import ssc.zork.MyMap;
import ssc.zork.Player;
import ssc.zork.Room;

import java.io.*;
import java.util.*;

public class HauntedCastleMap implements MyMap {
    private static final int rows = 5;
    private static final int cols = 6;
    private Player player;
    private Room[][] rooms;
    private int numRooms;
    //    public File gameMap;
    private String[][] mapToPrint;
    private String autoFileName;
    private boolean finished;
    private boolean isAutoPilot;
    private int[] linearTransformRow = new int[rows];
    private int[] linearTransformCol = new int[cols];

    public HauntedCastleMap(File file) {
        numRooms = 0;
        isAutoPilot = false;
        InRoomFactory inRoomFactory = new InRoomFactory();
        finished = false;
        for (int i = 0; i < rows; i++) {
            linearTransformRow[i] = i * 2;
        }
        for (int i = 0; i < cols; i++) {
            linearTransformCol[i] = i * 2;
        }
        rooms = new Room[rows][cols];
        mapToPrint = new String[2 * rows - 1][2 * cols - 1];
        String map = "Haunted_castle_map.txt";
//        File gameMap = new File(map);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            br.readLine();
            int row = 0;
            while (row < rows) {
                line = br.readLine();
                String[] splitData = line.split(" ");
                for (int col = 0; col < splitData.length; col++) {
                    if (Integer.parseInt(splitData[col]) == -1) {
                        rooms[row][col] = null;
                    } else {
                        rooms[row][col] = new Room();
                        int status = Integer.parseInt(splitData[col]);
                        rooms[row][col].setStatus(inRoomFactory.createInRoom(status));
                        if (rooms[row][col].getHasMonster()) numRooms++;
                    }
                }
                row++;
            }
            line = br.readLine();
            String[] position = line.split(",");
            int posX = Integer.parseInt(position[0]);
            int posY = Integer.parseInt(position[1]);
            player = new Player(posX, posY);
            rooms[posX][posY].setVisited(true);
            line = br.readLine();
            String[] status = line.split(",");
            player.setHealth(Integer.valueOf(status[0]));
            player.setPower(Integer.valueOf(status[1]));
            player.setShield(Integer.valueOf(status[2]));
            if ((line = br.readLine()) != null) {
                String[] items = line.split(",");
                List<String> myItems = new ArrayList<>(Arrays.asList(items));
                player.setItems(myItems);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileReader fr = new FileReader(map);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            int row = 0;
            while (row < rows) {
                line = br.readLine();
                String[] splitData = line.split(" ");
                for (int col = 0; col < splitData.length; col++) {
                    int newRow = linearTransformRow[row];
                    int newCol = linearTransformCol[col];
                    if (splitData[col].equals("x")) {
                        mapToPrint[newRow][newCol] = " ";
                    } else {
                        Set<String> directions = new HashSet<>(Arrays.asList(splitData[col].split(",")));
                        rooms[row][col].setDirectionList(directions);
                        mapToPrint[newRow][newCol] = "o";
                        if (directions.contains("E")) mapToPrint[newRow][newCol + 1] = "-";
                        if (directions.contains("W")) mapToPrint[newRow][newCol - 1] = "-";
                        if (directions.contains("N")) mapToPrint[newRow - 1][newCol] = "|";
                        if (directions.contains("S")) mapToPrint[newRow + 1][newCol] = "|";
                    }
                }
                row++;
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public HauntedCastleMap() {
        numRooms = 0;
        isAutoPilot = false;
        finished = false;
        for (int i = 0; i < rows; i++) {
            linearTransformRow[i] = i * 2;
        }
        for (int i = 0; i < cols; i++) {
            linearTransformCol[i] = i * 2;
        }
        rooms = new Room[rows][cols];
        mapToPrint = new String[2 * rows - 1][2 * cols - 1];
        String map = "Haunted_castle_map.txt";
//        rooms = createMap(map);
//        File gameMap = new File(map);
        try {
            FileReader fr = new FileReader(map);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            int row = 0;
            while (row < rows) {

                line = br.readLine();
                String[] splitData = line.split(" ");
                for (int col = 0; col < splitData.length; col++) {
                    int newRow = linearTransformRow[row];
                    int newCol = linearTransformCol[col];
                    if (splitData[col].equals("x")) {
                        rooms[row][col] = null;
                        mapToPrint[newRow][newCol] = " ";
                    } else {
                        Set<String> directions = new HashSet<>(Arrays.asList(splitData[col].split(",")));
                        rooms[row][col] = new Room(directions);
                        if (rooms[row][col].getHasMonster()) numRooms++;
                        mapToPrint[newRow][newCol] = "o";
                        if (directions.contains("E")) mapToPrint[newRow][newCol + 1] = "-";
                        if (directions.contains("W")) mapToPrint[newRow][newCol - 1] = "-";
                        if (directions.contains("N")) mapToPrint[newRow - 1][newCol] = "|";
                        if (directions.contains("S")) mapToPrint[newRow + 1][newCol] = "|";
                    }
                }
                row++;
            }
            line = br.readLine();
            String[] position = line.split(",");
            int posX = Integer.parseInt(position[0]);
            int posY = Integer.parseInt(position[1]);
            player = new Player(posX, posY);
            rooms[posX][posY].setVisited(true);
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            ;
        }
    }

    @Override
    public Room whereYouAre() {
        int[] position = this.player.getPosition();
        Room room = this.rooms[position[0]][position[1]];
        return room;
    }

    @Override
    public void quit() {
        finished = true;
    }

    @Override
    public int getObjective() {
        return numRooms;
    }

    @Override
    public boolean isFinished() {
        return (player.getProgression() == numRooms) || finished;
    }

    @Override
    public boolean finishObjective() {
        return (player.getProgression() == numRooms);
    }

    @Override
    public boolean autoPilot() {
        return isAutoPilot;
    }

    @Override
    public String getAutoFileName() {
        return autoFileName;
    }

    @Override
    public void setAutoPilot(boolean isAuto, String fileName) {
        this.isAutoPilot = isAuto;
        this.autoFileName = fileName;
    }

    public int[] getPlayerPosition() {
        return player.getPosition();
    }

    @Override
    public Room[][] createMap(String mapName) {
        return null;
    }

    @Override
    public void setPlayer(String direction) {
        if (direction.equals("N")) {
            player.setPosition(true, -1);
        } else if (direction.equals("S")) {
            player.setPosition(true, 1);
        } else if (direction.equals("E")) {
            player.setPosition(false, 1);
        } else if (direction.equals("W")) {
            player.setPosition(false, -1);
        }
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public Room[][] getRooms() {
        return rooms;
    }

    @Override
    public void printMap() {
        int[] playerPosition = getPlayerPosition();
        int posX = linearTransformRow[playerPosition[0]];
        int posY = linearTransformCol[playerPosition[1]];
        System.out.println();
        for (int i = 0; i < 2 * rows - 1; i++) {
//            boolean isNewLine= true;
            for (int j = 0; j < 2 * cols - 1; j++) {
                if (i == posX && j == posY) {
                    System.out.printf("p");
                } else if (mapToPrint[i][j] == null) {
                    System.out.printf(" ");
                } else
                    System.out.printf("%s", mapToPrint[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
