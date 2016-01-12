package com.trucktrack.core.module.geolocation.dao.impl;

import java.util.List;

import com.trucktrack.core.common.dao.CommonDAO;
import com.trucktrack.core.module.geolocation.dao.IGeoLocationDAO;
import com.trucktrack.core.module.geolocation.model.City;

public class GeoLocationDAO extends CommonDAO implements IGeoLocationDAO {

	@Override
	public void addCity(City city) {
		getSqlMapClientTemplate().insert("addCity", city);
	}

	@Override
	public void updateCity(City city) {
		getSqlMapClientTemplate().update("updateCity", city);
	}
	
	@Override
	public void deleteCity(String id) {
		getSqlMapClientTemplate().delete("deleteCity", id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<City> getAllCities(String criteria) {
		return getSqlMapClientTemplate().queryForList("getCities", criteria);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<City> getCitiesByCountry(String isoCode) {
		return getSqlMapClientTemplate().queryForList("getCitiesByCountry", isoCode);
	}

	@Override
	public City getCity(String id) {
		return (City) getSqlMapClientTemplate().queryForObject("getCity", id);
	}
	
}
