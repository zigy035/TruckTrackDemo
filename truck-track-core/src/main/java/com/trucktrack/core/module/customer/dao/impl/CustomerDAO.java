package com.trucktrack.core.module.customer.dao.impl;

import java.util.List;

import com.trucktrack.core.common.dao.CommonDAO;
import com.trucktrack.core.module.customer.dao.ICustomerDAO;
import com.trucktrack.core.module.customer.model.Customer;

public class CustomerDAO extends CommonDAO implements ICustomerDAO
{

	@SuppressWarnings("unchecked")
	public List<Customer> getCustomers()
	{
		return getSqlMapClientTemplate().queryForList("getCustomers");
	}

	public Long addCustomer(Customer customer)
	{
		return (Long) getSqlMapClientTemplate().insert("addCustomer", customer);
	}

	public void updateCustomer(Customer customer)
	{
		getSqlMapClientTemplate().update("updateCustomer", customer);
	}

	public void deleteCustomer(Customer customer)
	{
		getSqlMapClientTemplate().delete("deleteCustomer", customer);
	}

	public Customer getCustomerById(String id)
	{
		return (Customer) getSqlMapClientTemplate().queryForObject("getCustomerById", id);
	}
	
	@Override
	public Customer getCustomerByEmail(String email)
	{
		return (Customer) getSqlMapClientTemplate().queryForObject("getCustomerByEmail", email);
	}

}
