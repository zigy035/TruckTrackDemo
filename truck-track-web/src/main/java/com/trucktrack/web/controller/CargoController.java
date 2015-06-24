package com.trucktrack.web.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.trucktrack.core.module.cargo.dao.ICargoDAO;
import com.trucktrack.core.module.cargo.model.Cargo;
import com.trucktrack.web.model.CargoView;
import com.trucktrack.web.util.CountryUtils;
import com.trucktrack.web.validator.CargoValidator;

@Controller
@RequestMapping(value = "/cargo")
public class CargoController
{
	private Logger logger = LoggerFactory.getLogger(CargoController.class);

	@Autowired
	private ICargoDAO cargoDAO;
	
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
	
	private String buildCriteria(String countryFrom, String countryTo)
	{
		StringBuilder criteria = new StringBuilder();
		criteria.append(" 1=1");			
		if (countryFrom != null && !countryFrom.isEmpty())
		{
			criteria.append(" AND c.ref_country_code_from = '").append(countryFrom).append("'");
		}			
		if (countryTo != null && !countryTo.isEmpty())
		{
			criteria.append(" AND c.ref_country_code_to = '").append(countryTo).append("'");
		}
		
		return criteria.toString();
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String createForm(Model model)
	{
		model.addAttribute("cargoView", new CargoView());
		return "cargoForm";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String create(Model model, @ModelAttribute("cargoView") CargoView cargoView, BindingResult result)
	{
		cargoValidator.validate(cargoView, result);
		if (result.hasErrors())
		{
			logger.error(result.getFieldErrors().toString());
			model.addAttribute("cargoView", cargoView);
			return "cargoForm";
		}
		
		Cargo cargo = new Cargo();
		
		// Will be changed when date-picker is set
		cargo.setDeadline(new Date());
		cargo.setAddressFrom(cargoView.getAddressFrom());
		cargo.setAddressTo(cargoView.getAddressTo());
		cargo.setDimLength(Double.valueOf(cargoView.getDimLength()));
		cargo.setDimWeight(Double.valueOf(cargoView.getDimWeight()));
		cargo.setType(cargoView.getType());
		
		cargoDAO.addCargo(cargo);
		
		return "redirect:/cargo/list";
	}
	
}
