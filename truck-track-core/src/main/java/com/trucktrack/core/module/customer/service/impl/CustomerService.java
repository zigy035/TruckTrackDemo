package com.trucktrack.core.module.customer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import com.trucktrack.core.module.customer.dao.ICustomerDAO;
import com.trucktrack.core.module.customer.model.Customer;
import com.trucktrack.core.module.customer.service.ICustomerService;
import com.trucktrack.core.module.user.dao.IUserDAO;
import com.trucktrack.core.module.user.model.User;

public class CustomerService implements ICustomerService {
	
	@Autowired
	private ICustomerDAO customerDAO;
	
	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private ShaPasswordEncoder passwordEncoder;
	
	@Override
	public void register(Customer customer, User user) {
		user.setPassword(passwordEncoder.encodePassword(user.getPassword(), null));
		userDAO.addUser(user);
		customerDAO.addCustomer(customer);
	}

}
