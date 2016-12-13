package by.htp.cityname.logic;

import java.io.IOException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLReaderFactory;

import by.htp.cityname.entity.CitySet;
import by.htp.cityname.runner.Configurator;

public class XMLReader {
	
	private String fileXML = Configurator.getKey("fileXML");
	
	public XMLReader(CitySet cities){
		readerXML(cities);
	}
	
	public void readerXML(CitySet cities){
		try {
			org.xml.sax.XMLReader reader = XMLReaderFactory.createXMLReader();
			InputSource source = new InputSource(fileXML);
			XMLSAXHandler handler = new XMLSAXHandler(cities);
			reader.setContentHandler(handler);
			
			try {
				reader.parse(source);
			} catch (IOException e) {
				System.out.println("Проблемы с файлом " + fileXML);
			}
		} catch (SAXException e) {
			System.out.println("Проблемы с работой SAX пакетов.");
		}
	}
}
