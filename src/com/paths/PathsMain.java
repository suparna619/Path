package com.paths;

public class PathsMain {

    public static void main(String[] args) {
        String sourceStaton = args[0];
        String destinationStation = args[1];
        Paths newPath = new Paths();
        String path;
        if(!newPath.isStationPresent(sourceStaton)){
            System.out.println("No city named '" + sourceStaton + "' in database");
        }
        if(!newPath.isStationPresent(destinationStation)){
            System.out.println("No city named '" + destinationStation + "' in database");
        }
        else
            System.out.println(newPath.printPath(sourceStaton,destinationStation));
    }
}
