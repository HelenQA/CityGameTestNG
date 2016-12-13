package by.htp.cityname.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.mockito.Mockito.*;

import by.htp.cityname.entity.City;
import by.htp.cityname.entity.CitySet;

public class MenuItemsTest {
	public static CitySet cities; 
	public static String value;
	
	
	@BeforeClass
	public static void OnlyOnce(){
		cities = mock(CitySet.class);
		value = Configurator.getKey("city1Name");
	}
	
	@Ignore("Doesn't work in Maven")
	@Test(expected = Exception.class)
	public void citiesNull() {
		MenuOperations.processCity(null, cities, value);
	}

	//@Ignore("Doesn't work in Maven")
	@Test(expected = Exception.class)
	public void valueNull() {
		MenuOperations.processCity(cities, cities, null);
	}
	
	@AfterClass
	public static void afterClean(){
		cities = null;
		value = null;
	}
}
