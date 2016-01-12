package com.trucktrack.core.module.geolocation.dao;

import java.util.List;

import com.trucktrack.core.module.geolocation.model.City;

public interface IGeoLocationDAO {
	
	City getCity(String id);
	
	void addCity(City city);

	void updateCity(City city);
	
	void deleteCity(String id);

	List<City> getAllCities(String criteria);
	
	List<City> getCitiesByCountry(String isoCode);
}
