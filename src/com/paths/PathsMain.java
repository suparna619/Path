package com.paths;

import static java.lang.System.exit;

public class PathsMain {

    public static void main(String[] args) {
        String option = args[0];
        String file = args[1];
        String sourceStation = args[2].toLowerCase();
        String destinationStation = args[3].toLowerCase();
        ReadFile fileReader = new ReadFile();
        String content = fileReader.readFile(file);
        Paths path = new Paths(content);

        if(!option.equals("-f")) {
            System.out.println("Wrong Option '"+option+"'");
            exit(0);
        }
        if(!path.isStationPresent(sourceStation)){
            System.out.println("No city named '" + sourceStation.toUpperCase() + "' in database");
            exit(0);
        }
        if(sourceStation.equals(destinationStation)){
            System.out.println("Source and Destination are equal");
            exit(0);
        }
        if(!path.isStationPresent(destinationStation)){
            System.out.println("No city named '" + destinationStation.toUpperCase() + "' in database");
            exit(0);
        }
        else
            System.out.println(path.printPath(sourceStation,destinationStation));
    }
}
