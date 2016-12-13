package by.htp.cityname.entity;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.htp.cityname.runner.Configurator;

public class CityTest {
	
	@DataProvider(name = "Data")
	   public Object[][] dataSource() {
	      return new Object[][] {
	    	  {Configurator.getKey("city1Name"), Configurator.getKey("city1firstChar").charAt(0), Configurator.getKey("city1lastChar").charAt(0)},
	          {Configurator.getKey("city2Name"), Configurator.getKey("city2firstChar").charAt(0), Configurator.getKey("city2lastChar").charAt(0)},
	          {Configurator.getKey("city3Name"), Configurator.getKey("city3firstChar").charAt(0), Configurator.getKey("city3lastChar").charAt(0)},
	    	  };
	   }
	
    City city;
    
	@Test(dataProvider = "Data")
	public void tstName(String cityName, char firstChar, char cityLastChar) {
		city = new City(cityName);
		Assert.assertEquals(cityName, city.getName());
	}
	
	@Test(dataProvider = "Data")
	public void tstFirstChar(String cityName, char cityFirstChar, char cityLastChar) {
		city = new City(cityName);
		Assert.assertEquals(cityFirstChar, city.getFirstChar());
	}
	
	@Test(dataProvider = "Data")
	public void tstLastChar(String cityName, char cityFirstChar, char cityLastChar) {
		city = new City(cityName);
		Assert.assertEquals(cityLastChar, city.getLastChar());
	}
	
}
