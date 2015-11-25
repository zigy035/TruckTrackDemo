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
	
}
