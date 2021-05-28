package ssc.zork;

public class Position {
    public int x,y;
    public Position(int xx, int yy) {
        x = xx;
        y = yy;
    }
    public int[] getPosition(){
        return new int[]{x,y};
    }
}
