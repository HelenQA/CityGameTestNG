package by.htp.cityname.entity;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;

import by.htp.cityname.runner.Configurator;

public class CitySetTest {

	public static CitySet cities;
	public static String cityName1 = Configurator.getKey("city1Name");
	public static City city1;
	public static City city2;
	public static int NumOfCities = 1;

	@BeforeClass
	public static void OnlyOnce() {
		cities = new CitySet();
		city1 = new City(cityName1);
		cities.addCity(city1);
		city2 = null;
	}
	
	@Test
	public void tstCityAdd() {
		assertFalse("city2 not added",cities.addCity(city2));
	}
	
	@Test
	public void tstCityNumberOfElements() {
		assertEquals("Number of cities", NumOfCities, cities.numberOfElements());
	}
	
	@Test
	public void tstCityRemove() {
		assertTrue("city1 removed", cities.removeCity(city1));
	}
	
	@Test
	public void tstCityContains(){
		assertTrue("city1 in cities", cities.containsCity(new City(cityName1)));
	}
	
	@Test
	public void tstIteratorCity(){
		Iterator<City> iterator = cities.iterator();
		int index = 0;
		while (iterator.hasNext()){
			index++;
			if (index == 20) {break;}
		}
		assertEquals("TROUBLE WITH ITERATOR", cities.numberOfElements(),index);
	}
	
	@AfterClass
	public static void afterClean() {
		city1 = null;
		city2 = null;
		cities = null;
	}
}
