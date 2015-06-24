package com.trucktrack.web.util;

import com.trucktrack.core.module.customer.model.Customer;
import com.trucktrack.web.model.CustomerView;

public class CustomerUtils
{
	public static Customer createCustomer(CustomerView customerView)
	{
		Customer customer = new Customer();
		customer.setName(customerView.getName());
		customer.setContactPerson(customerView.getContactPerson());
		customer.setRefCountryCode(customerView.getRefCountryCode());
		customer.setAddress(customerView.getAddress());
		customer.setCity(customerView.getCity());
		customer.setPostcode(customerView.getPostcode());
		customer.setEmail(customerView.getEmail());
		customer.setMemo(customerView.getMemo());
		customer.setTelephone(customerView.getTelephone());
		customer.setStatus(1);
		
		return customer;		
	}
}
