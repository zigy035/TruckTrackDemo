package com.trucktrack.core.module.cargo.importer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trucktrack.core.module.cargo.dao.ICargoDAO;
import com.trucktrack.core.module.cargo.model.Cargo;

public class CargoImporter
{
	
	public static void main(String[] args)
	{
		String CARGO_DATA_URL = "http://www.timocom.com/sec/900110/index.cfm?goPt=angebotslistetc&vland=DE&nland=RS";
		
		// /truck-track-core/src/main/resources/com.trucktrack.core.test.importer/dataImportContext.xml
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("classpath:dataImportContext.xml");
		ICargoDAO cargoDAO = (ICargoDAO) ctx.getBean("cargoDAO");
		
		Document doc;
		try
		{
			doc = Jsoup.connect(CARGO_DATA_URL).get();

			Element table = doc.getElementById("cargoListTable");
			Elements rows = table.getElementsByTag("tr");
			rows.remove(0);
			for (Element row : rows)
			{
				Elements rowCells = row.getElementsByTag("td");
				String deadline = rowCells.get(0).text();
				String addressFrom = rowCells.get(1).text();
				String addressTo = rowCells.get(2).text();
				String dimLength = rowCells.get(3).text();
				String dimWeight = rowCells.get(4).text();
				String type = rowCells.get(5).text();
				
				// AddressFrom split
				String [] addressFromParts = addressFrom.split(" ");
				System.out.println("Country code from: " + addressFromParts[0]);
				System.out.println("Postcode from: " + addressFromParts[1]);
				StringBuilder cityFromStringBuilder = new StringBuilder();
				for (int i=2; i<addressFromParts.length; i++)
				{
					cityFromStringBuilder.append(addressFromParts[i]);
					if (i<addressFromParts.length)
					{
						cityFromStringBuilder.append(" ");
					}
				}
				System.out.println("City from: " + cityFromStringBuilder.toString());
				
				// AddressTo split
				String [] addressToParts = addressTo.split(" ");
				System.out.println("Country code to: " + addressToParts[0]);
				System.out.println("Postcode to: " + addressToParts[1]);
				StringBuilder cityToStringBuilder = new StringBuilder();
				for (int i=2; i<addressToParts.length; i++)
				{
					cityToStringBuilder.append(addressToParts[i]);
					if (i<addressToParts.length)
					{
						cityToStringBuilder.append(" ");
					}
				}
				System.out.println("City to: " + cityToStringBuilder.toString());
				
				// Persist to DB
				Cargo cargo = new Cargo();
				cargo.setPublished(new Date());
				cargo.setDeadline(parseDate(deadline));
				
				cargo.setAddressFrom(addressFrom);
				cargo.setRefCountryCodeFrom(addressFromParts[0]);
				cargo.setPostcodeFrom(addressFromParts[1]);
				cargo.setCityFrom(cityFromStringBuilder.toString());
				
				cargo.setAddressTo(addressTo);
				cargo.setRefCountryCodeTo(addressToParts[0]);
				cargo.setPostcodeTo(addressToParts[1]);
				cargo.setCityTo(cityToStringBuilder.toString());
				
				cargo.setDimLength(Double.valueOf(dimLength));
				cargo.setDimWeight(Double.valueOf(dimWeight));
				cargo.setType(type);
				
				cargoDAO.addCargo(cargo);	
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private static Date parseDate(String strDate)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");
		try
		{
			return dateFormat.parse(strDate);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	private static Date createDate(String strDate)
	{
		String [] strDateParts = strDate.split(".");
		Calendar cal = Calendar.getInstance();
		int year = Integer.valueOf("20" + strDateParts[2]);
		int month = Integer.valueOf(strDateParts[1]);
		int day = Integer.valueOf(strDateParts[0]);
		cal.set(year, month, day);
		
		return cal.getTime();
	}
	
}
