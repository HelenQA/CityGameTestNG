package by.htp.cityname.runner;

import java.util.Scanner;

import by.htp.cityname.entity.CitySet;
import by.htp.cityname.logic.XMLReader;

public class MenuItems {
	private static CitySet cities = new CitySet();
	private static CitySet usedCities = new CitySet();
	
	public static void menuStart(){
		@SuppressWarnings("unused")
		XMLReader reader = new XMLReader(cities);
		boolean exit = false;
		
		try(Scanner userInput = new Scanner(System.in)){
			
		while (!exit) {
			String value = userInput.nextLine();
			value = value.toUpperCase().trim();
			if (value.equals("")){
				System.out.println("Вы ничего не ввели.");
				System.out.print("Введите название города и нажмите enter: ");
				continue;
			}
			if (value.equals("0")) {
				exit = true;
			} else {
				exit = MenuOperations.processCity(cities, usedCities, value);
				continue;
			}
		}
		} catch (Exception e) {
			System.out.println("Error! " + e.getMessage());
		}
	}
}
