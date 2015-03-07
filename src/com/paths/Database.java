package com.paths;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database{
    public static Map<String,List<String>> pathInDataBase(String line){
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        String[] lines = line.split("\r\n");
        for(String singleLine:lines){
            String path[] = singleLine.split("[,]");
            List<String> destinations = map.get(path[0]);
            if(destinations == null){
                destinations = new ArrayList<String>();
                destinations.add(path[1]);
                map.put(path[0],destinations);
            }
            else{
                destinations.add(path[1]);
            }
        }
        return map;
    }

}