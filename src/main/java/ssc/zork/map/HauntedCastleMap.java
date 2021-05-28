package ssc.zork.map;
import ssc.zork.MyMap;
import ssc.zork.Player;
import ssc.zork.Room;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HauntedCastleMap implements MyMap{
    private static final int rows=5;
    private static final int cols=6;
    public Player player;
    public Room[][] rooms;
    public File gameMap;
    public String[][] mapToPrint;
    private boolean finished;
    private int[] linearTransformRow = new int[rows];
    private int[] linearTransformCol = new int[cols];
    public HauntedCastleMap() {
        finished = false;
        for(int i=0;i<rows;i++){
            linearTransformRow[i] = i*2;
        }
        for(int i=0;i<cols;i++){
            linearTransformCol[i] = i*2;
        }
        rooms = new Room[rows][cols];
        mapToPrint = new String[2*rows-1][2*cols-1];
        String map = "Haunted_castle_map.txt";
//        rooms = createMap(map);
        File gameMap = new File(map);
        try {
            Scanner readFile = new Scanner(gameMap);
//            String data = readFile.nextLine();
            String data = readFile.nextLine();
            int row = 0;
            while (row<rows) {
                data = readFile.nextLine();
                String[] splitData = data.split(" ");
                for (int col = 0; col < splitData.length; col++) {
                    int newRow = linearTransformRow[row];
                    int newCol = linearTransformCol[col];
                    if(splitData[col].equals("x")) {
                        rooms[row][col] = null;
                        mapToPrint[newRow][newCol] = "x";
                    } else {
//                        String[] x = splitData[col].split(",");
                        Set<String> directions = new HashSet<>(Arrays.asList(splitData[col].split(",")));
                        rooms[row][col] = new Room(directions);
                        mapToPrint[newRow][newCol] = "o";
                        if(directions.contains("E")) mapToPrint[newRow][newCol+1] = "-";
                        if(directions.contains("W")) mapToPrint[newRow][newCol-1] = "-";
                        if(directions.contains("N")) mapToPrint[newRow-1][newCol] = "|";
                        if(directions.contains("S")) mapToPrint[newRow+1][newCol] = "|";
                    }
                }
                row++;
            }
            data = readFile.nextLine();
            String[] position = data.split(",");
            int posX = Integer.parseInt(position[0]);
            int posY = Integer.parseInt(position[1]);
            player = new Player(posX,posY);
            rooms[posX][posY].setVisited(true);
            readFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    @Override
    public void quit() {
        finished = true;
    }
    @Override
    public boolean isFinished() {
        return finished;
    }
    public int[] getPlayerPosition() {
        return player.getPosition();
    }
    @Override
    public Room[][] createMap(String mapName) {
//        Room[][] rooms = new Room[rows][cols];
        return null;
    }
    @Override
    public void setPlayer(String direction){
//        System.out.println(direction);
        if(direction.equals("N")){
            player.setPosition(true,-1);
        }
        else if(direction.equals("S")){
            player.setPosition(true,1);
        }
        else if(direction.equals("E")){
            player.setPosition(false,1);
        }
        else if(direction.equals("W")){
            player.setPosition(false,-1);
        }
    }
    @Override
    public Player getPlayer(){
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
        for (int i = 0; i<2*rows-1; i++) {
            boolean isNewLine= true;
            for(int j=0;j<2*cols-1;j++) {
                if(i==posX&&j==posY){
                    System.out.printf("p");
                }
                else if(mapToPrint[i][j]==null){
                    System.out.printf(" ");
                } else
                System.out.printf("%s",mapToPrint[i][j]);
            }
            System.out.println();
        }
    }
}
