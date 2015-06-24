package com.trucktrack.core.module.customer.dao;

import java.util.List;

import com.trucktrack.core.module.customer.model.Customer;

public interface ICustomerDAO
{
	List<Customer> getCustomers();
	
	Customer getCustomerById(String id);
	
	Customer getCustomerByEmail(String email);
	
	Long addCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void deleteCustomer(Customer customer);
}
