package com.trucktrack.web.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trucktrack.core.module.geolocation.dao.IGeoLocationDAO;
import com.trucktrack.core.module.geolocation.model.City;
import com.trucktrack.web.form.CountryFormBean;

@Controller
@RequestMapping(value = "/country")
public class CountryController extends AbstractController {
	
	@Autowired
	private IGeoLocationDAO geoLocationDAO;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getCountryList(Model model)
	{
		// ModelAttribute annotation should return list of countries
		model.addAttribute("countryFormBean", new CountryFormBean());
		return "countryList";
	}
	
	@RequestMapping(value = "/cities", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<City> getCities(Model model, @RequestParam(value = "countryCode", required = false) String countryCode)
	{
		if (StringUtils.isBlank(countryCode)) {
			return null;
		}
		return geoLocationDAO.getCitiesByCountry(countryCode);
	}
	
	@RequestMapping(value = "/updatecity", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<City> updateCity(Model model, @RequestParam(value = "editId", required = false) String editId,
			@RequestParam(value = "editCity", required = false) String editCity, @RequestParam(value = "editPostCode", required = false) String editPostCode)
	{
		if (StringUtils.isBlank(editId) || StringUtils.isBlank(editCity) || StringUtils.isBlank(editPostCode)) {
			return null;
		}
		City city = geoLocationDAO.getCity(editId);
		if (city == null) {
			return null;
		}
		city.setName(editCity);
		city.setPostcode(editPostCode);
		geoLocationDAO.updateCity(city);
		
		return geoLocationDAO.getCitiesByCountry(city.getRefCountryCode());
	}
	
	@RequestMapping(value = "/deletecity", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<City> deleteCity(Model model, @RequestParam(value = "deleteId", required = false) String deleteId)
	{
		if (StringUtils.isBlank(deleteId)) {
			return null;
		}
		City city = geoLocationDAO.getCity(deleteId);
		geoLocationDAO.deleteCity(deleteId);
		
		return geoLocationDAO.getCitiesByCountry(city.getRefCountryCode());
	}
	
}
