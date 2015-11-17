package com.trucktrack.core.util.dataimport.city;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trucktrack.core.module.geolocation.dao.IGeoLocationDAO;
import com.trucktrack.core.module.geolocation.model.City;

public class SerbiaCityPostcodeImporter {
	
	public static void main(String[] args) {
			
		String CITY_POSTCODE_DATA_URL = "https://en.wikipedia.org/wiki/Postal_codes_in_Serbia";

		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:dataImportContext.xml");
		IGeoLocationDAO geoLocationDAO = (IGeoLocationDAO) ctx.getBean("geoLocationDAO");
		
		Document doc;
		try
		{
			doc = Jsoup.connect(CITY_POSTCODE_DATA_URL).get();
			
			Elements tables = doc.getElementsByTag("table");
			for (Element table : tables) {
				Elements rows = table.getElementsByTag("tr");
				for (Element row : rows) {
					Elements columns = row.getElementsByTag("td");
					if (columns != null && columns.size() == 2) {
						City city = new City();
						city.setName(columns.get(0).text());
						city.setPostcode(columns.get(1).text());
						city.setAllowed(true);
						city.setRefCountryCode("RS");
						geoLocationDAO.addCity(city);
						System.out.println("|"+columns.get(0).text()+"|"+columns.get(1).text()+"|");
					}
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Finished!");
		
	}
}
