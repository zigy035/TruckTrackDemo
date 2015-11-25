package com.trucktrack.core.util.dataimport.city;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trucktrack.core.module.geolocation.dao.IGeoLocationDAO;
import com.trucktrack.core.module.geolocation.model.City;

public class FranceCityPostcodeImporter {

	
	public static void main(String[] args) {
		
		String CITY_POSTCODE_DATA_URL = "https://simple.wikipedia.org/wiki/List_of_cities_in_France";
		
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
					if (columns.get(0).text().contains("Department")) {
						continue;
					}
					if (columns.get(0).text().equals("Roubaix")) {
						break;
					}
					City city = new City();
					city.setName(columns.get(0).text());
					city.setPostcode("france");
					city.setAllowed(true);
					city.setRefCountryCode("FR");
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
