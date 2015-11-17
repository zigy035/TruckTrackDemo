package com.trucktrack.core.util.dataimport.city;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trucktrack.core.module.geolocation.dao.IGeoLocationDAO;
import com.trucktrack.core.module.geolocation.model.City;

public class GermanyCityPostcodeImporter {
	
	public static void main(String[] args) {
		
		String CITY_POSTCODE_DATA_URL = "https://en.wikipedia.org/wiki/List_of_postal_codes_in_Germany";
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:dataImportContext.xml");
		IGeoLocationDAO geoLocationDAO = (IGeoLocationDAO) ctx.getBean("geoLocationDAO");

		Document doc;
		try {
			doc = Jsoup.connect(CITY_POSTCODE_DATA_URL).get();

			Element bodyContent = doc.getElementById("mw-content-text");
			
			Elements regions = bodyContent.getElementsByTag("ul");
			for (Element region : regions) {
				Elements cities = region.getElementsByTag("li");
				for (Element cityElem : cities) {
					String [] arrayTxt = cityElem.text().split(" - ");
					if (arrayTxt[0].length() < 5 && !arrayTxt[0].contains("xx") && arrayTxt.length > 1 && StringUtils.isNotBlank(arrayTxt[1])
							&& arrayTxt.length < 3) {
						City city = new City();
						city.setPostcode(arrayTxt[0]);
						city.setName(arrayTxt[1]);
						city.setAllowed(true);
						city.setRefCountryCode("DE");
						geoLocationDAO.addCity(city);
						System.out.println("|"+arrayTxt[0]+"|"+arrayTxt[1]+"|");
					}
				}
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Finished!");
	}
	
}
