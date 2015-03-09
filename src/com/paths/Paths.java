package com.paths;

import java.util.*;


public class Paths {
	public Map<String, List<String>> map = new HashMap<String, List<String>>();
    public Map<String,String> getCountryName = new HashMap<String,String>();

	Queue<String> sourceToDestinationPath = new LinkedList<String>();

    public Paths(String pathContent, String countyContent){
        this.map = Database.pathInDataBase(pathContent);
        this.getCountryName = Database.countryReader(countyContent);
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
        String fullPath = "";
        hasWay(source,destination);
        int length = sourceToDestinationPath.size();
        for(int i=0;i<length;i++){
            String cityName = sourceToDestinationPath.poll();
            if(i==0)
                fullPath +=""+cityName.toUpperCase()+"["+getCountryName.get(cityName)+"]";
            else
                fullPath +=" -> "+cityName.toUpperCase()+"["+getCountryName.get(cityName)+"]";
        }
        return fullPath;
    }
}