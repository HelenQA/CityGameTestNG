package by.htp.cityname.logic;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.htp.cityname.entity.City;
import by.htp.cityname.entity.CitySet;

public class XMLSAXHandler extends DefaultHandler {

	private String strThisElement;
	CitySet cities = new CitySet();

	public XMLSAXHandler(CitySet cities) {
		this.cities = cities;
	} 

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		strThisElement = qName;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (strThisElement.equals("name")) {
			City city = new City(new String(ch, start, length).toUpperCase());
			cities.addCity(city);
		}
	}
}
