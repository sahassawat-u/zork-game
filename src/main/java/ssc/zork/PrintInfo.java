package ssc.zork;

public class PrintInfo {
    public static void printHeader() {
        System.out.println("This is ZORK, command line based game");
        System.out.println("The object is to go through all the rooms without dying");
    }
    public static void printStartingGame() {
        System.out.println("choose the map:");
        System.out.println("  (1) Haunted Castle/ (2) Silent Forest");
        System.out.println("or load your saved map");
    }
}
