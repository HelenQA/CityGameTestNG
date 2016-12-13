package by.htp.cityname.entity;

import java.util.HashSet;
import java.util.Iterator;

@SuppressWarnings("rawtypes")
public class CitySet implements Iterable {
	private HashSet<City> cities;
	
	public CitySet() {
		this.cities = new HashSet<City>();
	}
	
	public boolean addCity(City city){
		if (city != null) 
		{
			return cities.add(city);
		} return false;
	}
	
	public boolean removeCity(City city){
		if (city != null) 
		{
			return cities.remove(city);
		} return false;
	}
	
	public int numberOfElements(){
		return cities.size();
	}
		
	@Override
	public String toString() {
		return "CityList [cities=" + cities + "]";
	}

	@Override
	public Iterator<City> iterator() {
		return cities.iterator();
	}

	public boolean containsCity(City city) {
		if (city != null) 
		{
			return cities.contains(city);
		} return false;
	}
}
