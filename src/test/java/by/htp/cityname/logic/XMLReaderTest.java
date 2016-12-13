package by.htp.cityname.logic;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import by.htp.cityname.entity.City;
import by.htp.cityname.entity.CitySet;
import by.htp.cityname.runner.Configurator;


@RunWith(Parameterized.class)

public class XMLReaderTest {
	
	public String cityName;
	
	public XMLReaderTest(String name){
		this.cityName = name;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> getTestData(){
		return Arrays.asList(new Object[][]{
			{Configurator.getKey("city1Name")},
			{Configurator.getKey("city2Name")},
			{Configurator.getKey("city3Name")},
		});
	}
	
	public String fileXML = Configurator.getKey("fileXML");
	public static CitySet cities;
	
	@BeforeClass
	public static void OnlyOnce(){
		cities = new CitySet();
		@SuppressWarnings("unused")
		XMLReader reader = new XMLReader(cities);
	}
	
	@Test
	public void ifXMLWasRead(){
		assertTrue(cities.containsCity(new City(cityName)));
	}
	
	@AfterClass
	public static void afterClean(){
		cities = null;
	}

}
