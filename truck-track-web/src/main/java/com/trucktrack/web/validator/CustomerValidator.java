package com.trucktrack.web.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.trucktrack.core.module.customer.dao.ICustomerDAO;
import com.trucktrack.web.model.CustomerView;

public class CustomerValidator implements Validator
{
	@Autowired
	private ICustomerDAO customerDAO;
	
	@Override
	public boolean supports(Class<?> clazz)
	{
		return true;
	}

	@Override
	public void validate(Object object, Errors errors)
	{
		CustomerView customerView = (CustomerView) object;
		if (customerView.getName().isEmpty())
		{
			errors.rejectValue("name", "customer.name.required");
		}
		if (customerView.getContactPerson().isEmpty())
		{
			errors.rejectValue("contactPerson", "customer.contactperson.required");
		}
		if (customerView.getRefCountryCode().isEmpty())
		{
			errors.rejectValue("refCountryCode", "customer.countrycode.required");
		}
		if (customerView.getAddress().isEmpty())
		{
			errors.rejectValue("address", "customer.address.required");
		}
		if (customerView.getCity().isEmpty())
		{
			errors.rejectValue("city", "customer.city.required");
		}
		if (customerView.getPostcode().isEmpty())
		{
			errors.rejectValue("postcode", "customer.postcode.required");
		}
		if (customerView.getTelephone().isEmpty())
		{
			errors.rejectValue("telephone", "customer.telephone.required");
		}
		if (customerView.getEmail().isEmpty())
		{
			errors.rejectValue("email", "customer.email.required");
		}
		else if (!EmailValidator.getInstance().isValid(customerView.getEmail()))
		{
			errors.rejectValue("email", "customer.email.invalid");
		}
		else if (customerDAO.getCustomerByEmail(customerView.getEmail()) != null)
		{
			errors.rejectValue("email", "customer.email.exists");
		}

	}

}
