package by.htp.cityname.entity;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import by.htp.cityname.runner.Configurator;
//import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class CityTest {
	
	public String name;
	public char firstChar;
	public char lastChar;
	
	public CityTest(String name, char firstChar, char lastChar){
		this.name = name;
		this.firstChar = firstChar;
		this.lastChar = lastChar;
	}
	
	@Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
          return Arrays.asList(new Object[][]{
        {Configurator.getKey("city1Name"), Configurator.getKey("city1firstChar").charAt(0), Configurator.getKey("city1lastChar").charAt(0)},
        {Configurator.getKey("city2Name"), Configurator.getKey("city2firstChar").charAt(0), Configurator.getKey("city2lastChar").charAt(0)},
        {Configurator.getKey("city3Name"), Configurator.getKey("city3firstChar").charAt(0), Configurator.getKey("city3lastChar").charAt(0)},
    });
 }
    
    City city;
    
	@Before
	public void onlyOnce() {
		city = new City(name);
		
	}

	@Test
	public void tstName() {
		assertEquals(name, city.getName());
	}
	
	@Test
	public void tstFirstChar() {
		assertEquals(firstChar, city.getFirstChar());
	}
	
	@Test
	public void tstLastChar() {
		assertEquals(lastChar, city.getLastChar());
	}
}
