package by.htp.cityname.runner;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Configurator {
static private ResourceBundle resBundle;
	
	
	static {
		resBundle = ResourceBundle.getBundle("prop");
	}
	
	public static String getKey(String key) {
		try {
			String value = resBundle.getString(key);
			return value;
		} catch (MissingResourceException e) {
			return null;
		}
	}

}
