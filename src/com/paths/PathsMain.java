package com.paths;

import static java.lang.System.exit;

public class PathsMain {

    public static void main(String[] args) {
        String optionFile = args[0];
        String file = args[1];
        String optionCountry = args[2];
        String countryFile = args[3];
        String sourceStation = args[4].toLowerCase();
        String destinationStation = args[5].toLowerCase();
        ReadFile fileReader = new ReadFile();
        String pathContainer = fileReader.readFile(file);
        String countyContainer = fileReader.readFile(countryFile);

        Paths path = new Paths(pathContainer,countyContainer);

        if(!optionFile.equals("-f")) {
            System.out.println("Wrong Option '"+optionFile+"'");
            exit(0);
        }
        if (!optionCountry.equals("-c")) {
            System.out.println("Wrong Option '"+optionCountry+"'");
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
