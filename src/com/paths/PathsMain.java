package com.paths;

import java.util.List;

import static java.lang.System.exit;

public class PathsMain {

    public static void main(String[] args) {
        String optionFile = args[0];
        String file = args[1];
        String optionCountry = args[2];
        String countryFile = args[3];
        String sourceStation = args[args.length-2].toLowerCase();
        String destinationStation = args[args.length-1].toLowerCase();
        ReadFile fileReader = new ReadFile();
        String pathContainer = fileReader.readFile(file);
        String countyContainer = fileReader.readFile(countryFile);

        Paths path = new Paths(pathContainer,countyContainer);

        OptionTester tester = new OptionTester(optionFile,optionCountry);
        tester.testOption();
        if (!path.source_destination_checker(sourceStation,destinationStation))
            exit(0);
        if (args[4].equals("-a")){
            List<String> list = path.printPath(sourceStation,destinationStation);
            int count = 1;
            for (String listElement : list) {
                System.out.println(count + ". " + listElement);
                count++;
            }
        }
        else
            System.out.println(path.printPath(sourceStation,destinationStation).get(0));

    }
}
