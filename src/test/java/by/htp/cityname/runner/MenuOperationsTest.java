package by.htp.cityname.runner;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import by.htp.cityname.entity.City;
import by.htp.cityname.entity.CitySet;

public class MenuOperationsTest {
	
	public static CitySet cities;
	public static CitySet usedCities;
	public static String value;
	public static City city;
	
	@BeforeClass
	public static void onlyOnce(){
		cities = new CitySet();
		usedCities = new CitySet();
	}
	
	@Before
	public void everyTime(){
		
	}

	//@Ignore
	@Test
	public void youWon() {
		cities.addCity(new City(Configurator.getKey("city1Name")));
		cities.addCity(new City(Configurator.getKey("city2Name")));
		value = Configurator.getKey("city1Name");
		assertTrue("You won!", MenuOperations.processCity(cities, usedCities, value));
	}
	
	//@Ignore
	@Test
	public void firstRun() {
		cities.addCity(new City(Configurator.getKey("city1Name")));
		cities.addCity(new City(Configurator.getKey("city3Name")));
		city = new City(Configurator.getKey("city1Name"));
		value = Configurator.getKey("city1Name");
		MenuOperations.processCity(cities, usedCities, value);
		System.out.println();
		assertFalse("City removed from 'cities'", cities.containsCity(city));
		assertTrue("City added to 'usedCities', AI proposes other city", usedCities.containsCity(city));
	}
	
	@AfterClass
	public static void afterClean(){
		cities = null;
		usedCities = null;
		city = null;
		value = null;
	}
}
