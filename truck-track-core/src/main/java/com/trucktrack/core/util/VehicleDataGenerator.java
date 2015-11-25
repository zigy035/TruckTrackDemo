package com.trucktrack.core.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trucktrack.core.common.enumeration.VehicleType;
import com.trucktrack.core.module.customer.dao.ICustomerDAO;
import com.trucktrack.core.module.customer.model.Customer;
import com.trucktrack.core.module.geolocation.dao.IGeoLocationDAO;
import com.trucktrack.core.module.geolocation.model.City;
import com.trucktrack.core.module.vehicle.dao.IVehicleDAO;
import com.trucktrack.core.module.vehicle.model.Vehicle;

public class VehicleDataGenerator {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:dataImportContext.xml");
		IGeoLocationDAO geoLocationDAO = (IGeoLocationDAO) ctx.getBean("geoLocationDAO");
		IVehicleDAO vehicleDAO = (IVehicleDAO) ctx.getBean("vehicleDAO");
		ICustomerDAO customerDAO = (ICustomerDAO) ctx.getBean("customerDAO");
		
		List<Customer> customers = customerDAO.getCustomers("c.email <> 'office@westum.com'");
		String [] countryCodes = {"AT","RS","DE","ES","NL","FR","IT"};
		Map<String,List<City>> countryCityMap = new HashMap<String, List<City>>();
		for (String code : countryCodes) {
			countryCityMap.put(code, geoLocationDAO.getCitiesByCountry(code));
		}
		
		for (Customer customer :  customers) {
			for (int i=0; i<20; i++) {
				Vehicle vehicle = new Vehicle();
				int vehicleType = (int)(Math.random()*(VehicleType.values().length-1));
				
				// Set Type
				vehicle.setVehicleType(vehicleType);
				// Set Customer
				vehicle.setRefCustomerId(customer.getId());
				
				// Set Country code (from/to)
				int countryCodeIdx = (int)(Math.random()*(countryCodes.length-1));
				if (vehicleType % 2 == 0) {
					vehicle.setRefCountryCodeFrom(customer.getRefCountryCode());
					vehicle.setRefCountryCodeTo(countryCodes[countryCodeIdx]);
				} else {
					vehicle.setRefCountryCodeFrom(countryCodes[countryCodeIdx]);
					vehicle.setRefCountryCodeTo(customer.getRefCountryCode());					
				}
				
				// Set City and Postal code(from/to)
				int cityFromIdx = (int)(Math.random()*(countryCityMap.get(vehicle.getRefCountryCodeFrom()).size()-1));
				int cityToIdx = (int)(Math.random()*(countryCityMap.get(vehicle.getRefCountryCodeTo()).size()-1));
				vehicle.setCityFrom(countryCityMap.get(vehicle.getRefCountryCodeFrom()).get(cityFromIdx).getName());
				vehicle.setCityTo(countryCityMap.get(vehicle.getRefCountryCodeTo()).get(cityToIdx).getName());
				vehicle.setPostCodeFrom(countryCityMap.get(vehicle.getRefCountryCodeFrom()).get(cityFromIdx).getPostcode());
				vehicle.setPostCodeTo(countryCityMap.get(vehicle.getRefCountryCodeTo()).get(cityToIdx).getPostcode());
				
				// Set published date
				vehicle.setPublished(new Date());
				
				// Set deadline date
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DAY_OF_MONTH, 7);
				vehicle.setDeadline(cal.getTime());
				
				// Set required dimensions
				Double [] dimLengthArr = {2.5, 3.6, 4.2, 7.8, 13.6, 14.4};
				Double [] dimWidthArr = {1.6, 2.1, 2.4, 3.2, 3.6, 4.5};
				int dimIdx = (int)(Math.random()*5);
				vehicle.setDimLength(dimLengthArr[dimIdx]);
				vehicle.setDimWeight(dimWidthArr[dimIdx]);
				
				vehicleDAO.add(vehicle);
			}
		}
		
	}
	
}
