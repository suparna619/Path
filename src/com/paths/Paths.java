package com.paths;

import java.util.*;


public class Paths {
	public Map<String, List<String>> map = new HashMap<String, List<String>>();
	List<String> sourceToDestinationPath = new ArrayList<String>();

    public Paths(String content){
        this.map = Database.pathInDataBase(content);
    }

	public boolean isStationPresent(String station){
		Set<String> sourceStations = map.keySet();
		if(sourceStations.contains(station))
			return true;
		else{
			for(String sourceElement : sourceStations){
				List<String> place = map.get(sourceElement) ;
				if(place.contains(station))
					return true;
			}
		}
		return false;
	}

	public boolean hasWay(String source, String destination){
		sourceToDestinationPath.add(source);
		return (findWay(source,destination));
	}

	public boolean findWay(String source, String destination){
		if(map.get(source) == null)
			return false;
		if(map.get(source).contains(destination)){
			sourceToDestinationPath.add(destination);
			return true;
		}
		if(!map.get(source).contains(destination)){			
			int size = map.get(source).size();
			for(int i = 0; i < size; i++){
				if(!sourceToDestinationPath.contains(map.get(source).get(i))){
					sourceToDestinationPath.add(map.get(source).get(i));
					return findWay(map.get(source).get(i),destination);
				}
			}
		}
		return false;
	}

	public String printPath(String source, String destination){
        hasWay(source,destination);
        return (String.join(" -> ",sourceToDestinationPath)).toUpperCase();
    }
}