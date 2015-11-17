package com.trucktrack.web.validator;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.trucktrack.web.form.CargoFormBean;

public class CargoValidator implements Validator
{

	@Override
	public boolean supports(Class<?> clazz)
	{
		return CargoFormBean.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors)
	{
		CargoFormBean cargoFormBean = (CargoFormBean) object;
		
		if (StringUtils.isBlank(cargoFormBean.getDeadline()))
		{
			errors.rejectValue("deadline", "cargo.deadline.required");
		}

		if (StringUtils.isBlank(cargoFormBean.getRefCountryCodeFrom()))
		{
			errors.rejectValue("refCountryCodeFrom", "cargo.countryfrom.required");
		}
		if (StringUtils.isBlank(cargoFormBean.getCityFrom()))
		{
			errors.rejectValue("cityFrom", "cargo.cityfrom.required");
		}
		if (StringUtils.isBlank(cargoFormBean.getPostCodeFrom()))
		{
			errors.rejectValue("postcodeFrom", "cargo.postcodefrom.required");
		}
		
		if (StringUtils.isBlank(cargoFormBean.getRefCountryCodeTo()))
		{
			errors.rejectValue("refCountryCodeTo", "cargo.countryto.required");
		}
		if (StringUtils.isBlank(cargoFormBean.getCityTo()))
		{
			errors.rejectValue("cityTo", "cargo.cityto.required");
		}
		if (StringUtils.isBlank(cargoFormBean.getPostCodeTo()))
		{
			errors.rejectValue("postCodeTo", "cargo.postcodeto.required");
		}
		
		if (StringUtils.isBlank(cargoFormBean.getDimLength()))
		{
			errors.rejectValue("dimLength", "cargo.length.required");
		}
		if (StringUtils.isBlank(cargoFormBean.getDimWeight()))
		{
			errors.rejectValue("dimWeight", "cargo.weight.required");
		}
		if (StringUtils.isBlank(cargoFormBean.getType()))
		{
			errors.rejectValue("type", "cargo.type.required");
		}

	}

}
