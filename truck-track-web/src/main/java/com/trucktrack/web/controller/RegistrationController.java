package com.trucktrack.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trucktrack.core.module.customer.dao.ICustomerDAO;
import com.trucktrack.core.module.customer.model.Customer;
import com.trucktrack.core.module.user.dao.IUserDAO;
import com.trucktrack.core.module.user.model.User;
import com.trucktrack.web.model.CustomerView;
import com.trucktrack.web.util.CountryUtils;
import com.trucktrack.web.util.CustomerUtils;
import com.trucktrack.web.util.UserUtils;
import com.trucktrack.web.validator.CustomerValidator;

@Controller
@RequestMapping(value = "/register")
public class RegistrationController 
{
	@Autowired
	private ICustomerDAO customerDAO;
	
	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private CustomerValidator customerValidator;

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String createForm(Model model)
	{
		model.addAttribute("countryCodes", CountryUtils.getCountryCodes());
		model.addAttribute("customerView", new CustomerView());
		return "registrationForm";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String create(Model model, @ModelAttribute("customerView") CustomerView customerView, BindingResult result)
	{
		customerValidator.validate(customerView, result);
		if (result.hasErrors())
		{
			model.addAttribute("customerView", customerView);
			return "registrationForm";
		}
		
		Customer customer = CustomerUtils.createCustomer(customerView);
		User user = UserUtils.createUser(customerView); 
		
		// This should be wrapped into transaction
		customerDAO.addCustomer(customer);
		userDAO.addUser(user);
		
		return "/confirmRegistration";
	}
	
}
