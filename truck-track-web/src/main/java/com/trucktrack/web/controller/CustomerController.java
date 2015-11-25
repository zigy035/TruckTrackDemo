package com.trucktrack.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trucktrack.core.module.customer.dao.ICustomerDAO;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController
{
	@Autowired
	private ICustomerDAO customerDAO;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getCustomers(Model model)
	{
		StringBuilder criteria = new StringBuilder();
		criteria.append(" 1=1");
		model.addAttribute("customers", customerDAO.getCustomers(criteria.toString()));
		return "customerList";
	}

}
