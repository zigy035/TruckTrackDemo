package com.trucktrack.web.util;

import com.trucktrack.core.module.customer.model.Customer;
import com.trucktrack.web.form.RegisterFormBean;

public class CustomerUtils
{
	public static Customer createCustomer(RegisterFormBean formBean)
	{
		Customer customer = new Customer();
		customer.setName(formBean.getName());
		customer.setContactPerson(formBean.getContactPerson());
		customer.setRefCountryCode(formBean.getRefCountryCode());
		customer.setAddress(formBean.getAddress());
		customer.setCity(formBean.getCity());
		customer.setPostcode(formBean.getPostcode());
		customer.setEmail(formBean.getEmail());
		customer.setMemo(formBean.getMemo());
		customer.setTelephone(formBean.getTelephone());
		customer.setStatus(1);
		
		return customer;		
	}
}
