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

import com.trucktrack.core.module.user.dao.IUserDAO;
import com.trucktrack.core.module.user.model.User;
import com.trucktrack.core.module.vehicle.dao.IVehicleDAO;
import com.trucktrack.core.module.vehicle.model.Vehicle;
import com.trucktrack.web.form.VehicleFormBean;
import com.trucktrack.web.validator.VehicleValidator;

@Controller
@RequestMapping(value = "/vehicle")
public class VehicleController extends AbstractController
{
	private Logger logger = LoggerFactory.getLogger(VehicleController.class);

	@Autowired
	private IVehicleDAO vehicleDAO;

	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private VehicleValidator vehicleValidator;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getVehicleList(Model model)
	{
		String criteria = buildCriteria("", "");
	    
		model.addAttribute("vehicles", vehicleDAO.getVehicles(criteria.toString()));
		return "vehicleList";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Vehicle> search(
			@RequestParam(value = "countryFrom", required = false) String countryFrom, 
			@RequestParam(value = "countryTo", required = false) String countryTo) {
		
		String criteria = buildCriteria(countryFrom, countryTo);
		
		List<Vehicle> vehicles = vehicleDAO.getVehicles(criteria);
		System.out.println("Num of vehicles: " + vehicles.size());
		
		return vehicles;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String createForm(Model model)
	{
		model.addAttribute("vehicleFormBean", new VehicleFormBean());
		return "vehicleForm";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String create(Model model, VehicleFormBean vehicleFormBean, BindingResult result)
	{
		vehicleValidator.validate(vehicleFormBean, result);
		if (result.hasErrors())
		{
			logger.error(result.getFieldErrors().toString());
			model.addAttribute("vehicleFormBean", vehicleFormBean);
			return "vehicleForm";
		}
		
		Vehicle vehicle = new Vehicle();
		
		// Will be changed when date-picker is set
		vehicle.setDeadline(new Date());
		
		vehicle.setRefCountryCodeFrom(vehicleFormBean.getRefCountryCodeFrom());
		vehicle.setCityFrom(vehicleFormBean.getCityFrom());
		vehicle.setPostCodeFrom(vehicleFormBean.getPostCodeFrom());
		
		vehicle.setRefCountryCodeTo(vehicleFormBean.getRefCountryCodeTo());
		vehicle.setCityTo(vehicleFormBean.getCityTo());
		vehicle.setPostCodeTo(vehicleFormBean.getCityTo());
		
		vehicle.setDimLength(Double.valueOf(vehicleFormBean.getDimLength()));
		vehicle.setDimWeight(Double.valueOf(vehicleFormBean.getDimWeight()));
		vehicle.setVehicleType(vehicleFormBean.getType());
		
		vehicleDAO.add(vehicle);
		
		return "redirect:/vehicle/list";
	}
	
	private String buildCriteria(String countryFrom, String countryTo)
	{
		User user = getLoggedUser();
		StringBuilder criteria = new StringBuilder();
		
		criteria.append("1=1 ");
		
		// USER==0 ADMIN==1
		if (user.getAccess() == 0) {
	    	criteria.append("AND v.ref_customer_id <> '").append(user.getRefCustomerId()).append("' ");
	    }
		
		if (StringUtils.isNotBlank(countryFrom))
		{
			criteria.append("AND v.ref_country_code_from = '").append(countryFrom).append("' ");
		}			
		if (StringUtils.isNotBlank(countryTo))
		{
			criteria.append("AND v.ref_country_code_to = '").append(countryTo).append("' ");
		}
		
		return criteria.toString();
	}
	
}
