package com.trucktrack.core.util.dataimport.city;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trucktrack.core.module.geolocation.dao.IGeoLocationDAO;
import com.trucktrack.core.module.geolocation.model.City;

public class SpainCityPostcodeImporter {

	
	public static void main(String[] args) {
		
		String CITY_POSTCODE_DATA_URL = "https://en.wikipedia.org/wiki/List_of_metropolitan_areas_in_Spain";
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:dataImportContext.xml");
		IGeoLocationDAO geoLocationDAO = (IGeoLocationDAO) ctx.getBean("geoLocationDAO");
		
		Document doc;
		try {
			doc = Jsoup.connect(CITY_POSTCODE_DATA_URL).get();
			
			Elements tables = doc.getElementsByTag("table");
			Element table = tables.get(0);
			Elements rows = table.getElementsByTag("tr");
			for (Element row : rows) {
				Elements columns = row.getElementsByTag("td");
				if (columns != null && columns.size() > 0) {
					if (columns.get(0).text().contains("Metropolitan")) {
						continue;
					}
					
					City city = new City();
					city.setName(columns.get(0).text());
					city.setPostcode("spain");
					city.setAllowed(true);
					city.setRefCountryCode("ES");
					geoLocationDAO.addCity(city);
					System.out.println("|"+columns.get(0).text()+"|");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Finished!");
	}
}
