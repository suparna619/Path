package com.paths;

import java.util.*;

public class Paths {
	public Map<String, List<String>> map = new HashMap<String, List<String>>();
    public Map<String,String> getCountryName = new HashMap<String,String>();

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

    public boolean source_destination_checker(String source, String destination){
        if(!isStationPresent(source)){
            System.out.println("No city named '" + source.toUpperCase() + "' in database");
            return false;
        }
        if(source.equals(destination)){
            System.out.println("Source and Destination are equal");
            return false;
        }
        if (!isStationPresent(destination)){
            System.out.println("No city named '" + destination.toUpperCase() + "' in database");
            return false;
        }
        return true;
    }

    public List<Queue<String>> getDirectPath(String source,String destination) {
        Queue<String> path = new LinkedList<String>();
        List<Queue<String>> AllRoots = new ArrayList<Queue<String>>();
        getPath(path, AllRoots, source, destination);
        return AllRoots;
    }

    public void  getPath(Queue<String>path,List<Queue<String>> AllRoots,String source,String destination){
        path.add(source);
        Set<String> cities = map.keySet();
        if(isStationPresent(source) && isStationPresent(destination)){

            if(source.equals(destination)){
                AllRoots.add(new LinkedList<String>(path));
                path.remove(source);
                return;
            }
            for(String city : cities){
                if(city.equals(source)) {
                    List<String> lists = map.get(city);
                    for(String list:lists){
                        if(!path.contains(list)){
                            getPath(path, AllRoots, list, destination);
                        }
                    }
                }

            }
        }
        path.remove(source);
    }

	public List<String> printPath(String source, String destination){
        List<Queue<String>> AllRoots = getDirectPath(source,destination);
        List<String> list = new ArrayList<String>();
        for(Queue<String> singleRoots:AllRoots) {
            String getfullpath = "";
            int length = singleRoots.size();
            for (int i = 0; i < length; i++) {
                String cityName = singleRoots.poll();
                if (i == 0)
                    getfullpath += "" + cityName + "[" + getCountryName.get(cityName) + "]";
                else
                    getfullpath += " -> " + cityName + "[" + getCountryName.get(cityName) + "]";
            }
            list.add(getfullpath);
        }
        return list;
    }
}