package com.trucktrack.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trucktrack.core.module.vehicle.dao.IVehicleDAO;
import com.trucktrack.core.module.vehicle.model.Vehicle;

@Controller
@RequestMapping(value = "/vehicle")
public class VehicleController
{
	private Logger logger = LoggerFactory.getLogger(VehicleController.class);

//	@Autowired
//	private IVehicleDAO vehicleDAO;
//
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	public String getAddressList(Model model)
//	{
//		model.addAttribute("vehicles", vehicleDAO.getAllProjects());
//		return "vehicle/list";
//	}
//
//	@RequestMapping(value = "/new", method = RequestMethod.GET)
//	public String createForm(Model model)
//	{
//		model.addAttribute("vehicle", new Vehicle());
//		return "vehicle/form";
//	}
//
//	@RequestMapping(value = "/create", method = RequestMethod.POST)
//	public String create(Vehicle vehicle, BindingResult result)
//	{
//		if (result.hasErrors())
//		{
//			logger.warn(result.getFieldErrors().toString());
//			return "vehicle/form";
//		}
//		vehicleDAO.insert(vehicle);
//		return "redirect:/vehicle/list";
//	}
}
