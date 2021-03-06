package com.trucktrack.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trucktrack.core.module.cargo.dao.ICargoDAO;
import com.trucktrack.web.util.CountryUtils;

@Controller
public class WelcomeController
{
	protected static Logger logger = Logger.getLogger(WelcomeController.class);
	
	@Autowired
	private ICargoDAO cargoDAO;
	
	@RequestMapping("/")
	public String getWelcomeData(Model model, @RequestParam(required = false) Integer currentPage)
	{		
		String criteria = " 1=1";
		int recordsPerPage = 10;
		int totalRows = cargoDAO.getCargosCount(" 1=1");
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
		model.addAttribute("countryFrom", "");
		model.addAttribute("countryTo", "");
		
		return "cargoList";
	}
}
