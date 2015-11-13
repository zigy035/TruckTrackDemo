package com.trucktrack.web.validator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.trucktrack.core.module.customer.dao.ICustomerDAO;
import com.trucktrack.web.form.RegisterFormBean;

public class CustomerValidator implements Validator
{
	@Autowired
	private ICustomerDAO customerDAO;
	
	@Override
	public boolean supports(Class<?> clazz)
	{
		return RegisterFormBean.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors)
	{
		RegisterFormBean formBean = (RegisterFormBean) object;
		if (StringUtils.isBlank(formBean.getName()))
		{
			errors.rejectValue("name", "customer.name.required");
		}
		if (StringUtils.isBlank(formBean.getContactPerson()))
		{
			errors.rejectValue("contactPerson", "customer.contactperson.required");
		}
		if (StringUtils.isBlank(formBean.getRefCountryCode()))
		{
			errors.rejectValue("refCountryCode", "customer.country.required");
		}
		if (StringUtils.isBlank(formBean.getAddress()))
		{
			errors.rejectValue("address", "customer.address.required");
		}
		if (StringUtils.isBlank(formBean.getCity()))
		{
			errors.rejectValue("city", "customer.city.required");
		}
		if (StringUtils.isBlank(formBean.getPostcode()))
		{
			errors.rejectValue("postcode", "customer.postcode.required");
		}
		if (StringUtils.isBlank(formBean.getTelephone()))
		{
			errors.rejectValue("telephone", "customer.telephone.required");
		}
		if (StringUtils.isBlank(formBean.getEmail()))
		{
			errors.rejectValue("email", "customer.email.required");
		}
		else if (!EmailValidator.getInstance().isValid(formBean.getEmail()))
		{
			errors.rejectValue("email", "customer.email.invalid");
		}
		else if (customerDAO.getCustomerByEmail(formBean.getEmail()) != null)
		{
			errors.rejectValue("email", "customer.email.exists");
		}
		if (StringUtils.isBlank(formBean.getFirstName()))
		{
			errors.rejectValue("firstName", "customer.firstname.required");
		}
		if (StringUtils.isBlank(formBean.getLastName()))
		{
			errors.rejectValue("lastName", "customer.lastname.required");
		}
		if (StringUtils.isBlank(formBean.getUsername()))
		{
			errors.rejectValue("username", "customer.username.required");
		}
		if (StringUtils.isBlank(formBean.getPassword()))
		{
			errors.rejectValue("password", "customer.password.required");
		}
		if (StringUtils.isBlank(formBean.getConfirmPassword()))
		{
			errors.rejectValue("confirmPassword", "customer.confirm.password.required");
		}
		else if (!formBean.getPassword().equals(formBean.getConfirmPassword()))
		{
			errors.rejectValue("confirmPassword", "customer.confirm.password.invalid");
		}
		if (!formBean.getTermsConditions())
		{
			errors.rejectValue("termsConditions", "customer.terms.conditions.required");
		}

	}

}
