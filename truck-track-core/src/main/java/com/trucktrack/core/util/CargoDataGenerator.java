package com.trucktrack.core.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trucktrack.core.common.enumeration.VehicleType;
import com.trucktrack.core.module.cargo.dao.ICargoDAO;
import com.trucktrack.core.module.cargo.model.Cargo;
import com.trucktrack.core.module.customer.dao.ICustomerDAO;
import com.trucktrack.core.module.customer.model.Customer;
import com.trucktrack.core.module.geolocation.dao.IGeoLocationDAO;
import com.trucktrack.core.module.geolocation.model.City;


public class CargoDataGenerator {
	
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:dataImportContext.xml");
		IGeoLocationDAO geoLocationDAO = (IGeoLocationDAO) ctx.getBean("geoLocationDAO");
		ICargoDAO cargoDAO = (ICargoDAO) ctx.getBean("cargoDAO");
		ICustomerDAO customerDAO = (ICustomerDAO) ctx.getBean("customerDAO");
		
		List<Customer> customers = customerDAO.getCustomers("c.email <> 'office@westum.com'");
		String [] countryCodes = {"AT","RS","DE","ES","NL","FR","IT"};
		Map<String,List<City>> countryCityMap = new HashMap<String, List<City>>();
		for (String code : countryCodes) {
			countryCityMap.put(code, geoLocationDAO.getCitiesByCountry(code));
		}
		
		/*
		 for every customer create several cargo items
		 every cargo item should have countryCodeFrom or countryCodeTo the same as customer country code (based on type%2 moduo condition)  
		 "AT","RS","DE" -> "ES","NL","FR" and vice versa
		*/
		for (Customer customer :  customers) {
			for (int i=0; i<20; i++) {
				Cargo cargo = new Cargo();
				int vehicleType = (int)(Math.random()*(VehicleType.values().length-1));
				
				// Set Type
				cargo.setVehicleType(vehicleType);
				// Set Customer
				cargo.setRefCustomerId(customer.getId());
				
				// Set Country code (from/to)
				int countryCodeIdx = (int)(Math.random()*(countryCodes.length-1));
				if (vehicleType % 2 == 0) {
					cargo.setRefCountryCodeFrom(customer.getRefCountryCode());
					cargo.setRefCountryCodeTo(countryCodes[countryCodeIdx]);
				} else {
					cargo.setRefCountryCodeFrom(countryCodes[countryCodeIdx]);
					cargo.setRefCountryCodeTo(customer.getRefCountryCode());					
				}
				
				// Set City and Postal code(from/to)
				int cityFromIdx = (int)(Math.random()*(countryCityMap.get(cargo.getRefCountryCodeFrom()).size()-1));
				int cityToIdx = (int)(Math.random()*(countryCityMap.get(cargo.getRefCountryCodeTo()).size()-1));
				cargo.setCityFrom(countryCityMap.get(cargo.getRefCountryCodeFrom()).get(cityFromIdx).getName());
				cargo.setCityTo(countryCityMap.get(cargo.getRefCountryCodeTo()).get(cityToIdx).getName());
				cargo.setPostCodeFrom(countryCityMap.get(cargo.getRefCountryCodeFrom()).get(cityFromIdx).getPostcode());
				cargo.setPostCodeTo(countryCityMap.get(cargo.getRefCountryCodeTo()).get(cityToIdx).getPostcode());
				
				// Set published date
				cargo.setPublished(new Date());
				
				// Set deadline date
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DAY_OF_MONTH, 7);
				cargo.setDeadline(cal.getTime());
				
				// Set required dimensions
				Double [] dimLengthArr = {2.5, 3.6, 4.2, 7.8, 13.6, 14.4};
				Double [] dimWidthArr = {1.6, 2.1, 2.4, 3.2, 3.6, 4.5};
				int dimIdx = (int)(Math.random()*5);
				cargo.setDimLength(dimLengthArr[dimIdx]);
				cargo.setDimWeight(dimWidthArr[dimIdx]);
				
				cargoDAO.addCargo(cargo);
			}
		}
		
	}
	
}
