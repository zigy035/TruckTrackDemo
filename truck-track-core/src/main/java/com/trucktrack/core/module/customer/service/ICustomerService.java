package com.trucktrack.core.module.customer.service;

import com.trucktrack.core.module.customer.model.Customer;
import com.trucktrack.core.module.user.model.User;

public interface ICustomerService {

	public void register(Customer customer, User user);
	
}
