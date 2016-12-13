package by.htp.cityname.entity;



import java.util.Iterator;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CitySetTest {

	public static CitySet cities;
	public static City city1;
	public static City city2;

	@BeforeClass
	@Parameters({"cityName"})
	public static void OnlyOnce(String cityName) {
		String[] name = cityName.split(";");
		cities = new CitySet();
		city1 = new City(name[0].trim());
		cities.addCity(city1);
		city2 = null;
	}
	
	@Test
	public void tstCityAdd() {
		Assert.assertFalse(cities.addCity(city2), "city2 not added");
	}
	
	@Test
	@Parameters({"NumOfCities"})
	public void tstCityNumberOfElements(int NumOfCities) {
		Assert.assertEquals(NumOfCities, cities.numberOfElements(), "Number of cities");
	}
	
	@Test
	public void tstCityRemove() {
		Assert.assertTrue(cities.removeCity(city1), "city1 removed");
	}
	
	@Test
	@Parameters({"cityName"})
	public void tstCityContains(String cityName){
		String[] name = cityName.split(";");
		Assert.assertTrue(cities.containsCity(new City(name[0].trim())), "city1 in cities");
	}
	
	@Test
	public void tstIteratorCity(){
		Iterator<City> iterator = cities.iterator();
		int index = 0;
		while (iterator.hasNext()){
			index++;
			if (index == 20) {break;}
		}
		Assert.assertEquals(index, cities.numberOfElements(), "TROUBLE WITH ITERATOR");
	}
	
	@AfterClass
	public static void afterClean() {
		city1 = null;
		city2 = null;
		cities = null;
	}
}
