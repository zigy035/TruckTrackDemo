package com.trucktrack.core.module.geolocation.dao;

import java.util.List;

import com.trucktrack.core.module.geolocation.model.City;

public interface IGeoLocationDAO {
	
	void addCity(City city);
	
	List<City> getAllCities(String criteria);
	
	List<City> getCitiesByCountry(String isoCode);
}
