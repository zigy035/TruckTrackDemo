package com.trucktrack.web.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trucktrack.core.module.cargo.dao.ICargoDAO;
import com.trucktrack.core.module.cargo.model.Cargo;
import com.trucktrack.core.module.geolocation.dao.IGeoLocationDAO;
import com.trucktrack.core.module.geolocation.model.City;
import com.trucktrack.core.module.user.model.User;
import com.trucktrack.web.form.CargoFormBean;
import com.trucktrack.web.util.CountryUtils;
import com.trucktrack.web.validator.CargoValidator;

@Controller
@RequestMapping(value = "/cargo")
public class CargoController extends AbstractController
{
	private Logger logger = LoggerFactory.getLogger(CargoController.class);

	@Autowired
	private ICargoDAO cargoDAO;
	
	@Autowired
	private IGeoLocationDAO geoLocationDAO;
	
	@Autowired
	private CargoValidator cargoValidator;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getCargoList(Model model, @RequestParam(required = false) String countryFrom, 
			@RequestParam(required = false) String countryTo, 
			@RequestParam(required = false) Integer currentPage)
	{
		String criteria = buildCriteria(countryFrom, countryTo);
		
		int recordsPerPage = 10;
		int totalRows = cargoDAO.getCargosCount(criteria);
		model.addAttribute("totalRows", totalRows);
		
		int pageCount = totalRows/recordsPerPage + totalRows%recordsPerPage;
		model.addAttribute("pageCount", pageCount);
		
		if (currentPage == null || currentPage < 1 || currentPage > pageCount)
		{
			currentPage = 1;
		}
		model.addAttribute("currentPage", currentPage);
		
		model.addAttribute("cargos", cargoDAO.getCargosWithLimit(criteria, currentPage, recordsPerPage));
		
		model.addAttribute("countryCodes", CountryUtils.getCountryCodes());
		model.addAttribute("countryFrom", countryFrom);
		model.addAttribute("countryTo", countryTo);
		
		return "cargoList";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Cargo> search(
			@RequestParam(value = "countryFrom", required = false) String countryFrom, 
			@RequestParam(value = "countryTo", required = false) String countryTo) {
		
		String criteria = buildCriteria(countryFrom, countryTo);
		
		List<Cargo> cargos = cargoDAO.getCargos(criteria);
		System.out.println("Num of cargos: " + cargos.size());
		
		return cargos;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String createForm(Model model)
	{
		model.addAttribute("cargoFormBean", new CargoFormBean());
		return "cargoForm";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String create(Model model, CargoFormBean cargoFormBean, BindingResult result)
	{
		cargoValidator.validate(cargoFormBean, result);
		if (result.hasErrors())
		{
			logger.error(result.getFieldErrors().toString());
			model.addAttribute("cargoFormBean", cargoFormBean);
			return "cargoForm";
		}
		
		Cargo cargo = new Cargo();
		
		// Will be changed when date-picker is set
		cargo.setDeadline(new Date());
		
		cargo.setRefCountryCodeFrom(cargoFormBean.getRefCountryCodeFrom());
		cargo.setCityFrom(cargoFormBean.getCityFrom());
		cargo.setPostCodeFrom(cargoFormBean.getPostCodeFrom());
		
		cargo.setRefCountryCodeTo(cargoFormBean.getRefCountryCodeTo());
		cargo.setCityTo(cargoFormBean.getCityTo());
		cargo.setPostCodeTo(cargoFormBean.getCityTo());
		
		cargo.setDimLength(Double.valueOf(cargoFormBean.getDimLength()));
		cargo.setDimWeight(Double.valueOf(cargoFormBean.getDimWeight()));
		cargo.setVehicleType(cargoFormBean.getType());
		
		cargoDAO.addCargo(cargo);
		
		return "redirect:/cargo/list";
	}
	
	@RequestMapping(value = "/getCities", method = RequestMethod.GET)
	public @ResponseBody List<City> getCities(@RequestParam("term") String query) {
		String criteria = "c.name LIKE '%" + query + "%'";
		List<City> cities = geoLocationDAO.getAllCities(criteria);
		System.out.println("Number of cities: " + cities.size());
		return cities;
	}
	
	private String buildCriteria(String countryFrom, String countryTo)
	{
		User user = getLoggedUser();
		StringBuilder criteria = new StringBuilder();
		
		criteria.append("1=1 ");
		
		// USER==0 ADMIN==1
		if (user.getAccess() == 0) {
	    	criteria.append("AND c.ref_customer_id <> '").append(user.getRefCustomerId()).append("' ");
	    }
		
		if (StringUtils.isNotBlank(countryFrom))
		{
			criteria.append("AND c.ref_country_code_from = '").append(countryFrom).append("' ");
		}			
		if (StringUtils.isNotBlank(countryTo))
		{
			criteria.append("AND c.ref_country_code_to = '").append(countryTo).append("' ");
		}
		
		return criteria.toString();
	}
	
}
