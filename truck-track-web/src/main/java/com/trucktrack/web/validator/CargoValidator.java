package com.trucktrack.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.trucktrack.web.model.CargoView;

public class CargoValidator implements Validator
{

	@Override
	public boolean supports(Class<?> clazz)
	{
		return true;
	}

	@Override
	public void validate(Object object, Errors errors)
	{
		CargoView cargoView = (CargoView) object;
		if (cargoView.getDeadline().isEmpty())
		{
			errors.rejectValue("deadline", "cargo.deadline.required");
		}
		if (cargoView.getAddressFrom().isEmpty())
		{
			errors.rejectValue("addressFrom", "cargo.addressfrom.required");
		}
		if (cargoView.getAddressTo().isEmpty())
		{
			errors.rejectValue("addressTo", "cargo.addressto.required");
		}
		if (cargoView.getDimLength().isEmpty())
		{
			errors.rejectValue("dimLength", "cargo.length.required");
		}
		if (cargoView.getDimWeight().isEmpty())
		{
			errors.rejectValue("dimWeight", "cargo.weight.required");
		}
		if (cargoView.getType().isEmpty())
		{
			errors.rejectValue("type", "cargo.type.required");
		}

	}

}
