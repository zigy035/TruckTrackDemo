package com.trucktrack.web.util;

import java.util.Calendar;

import com.trucktrack.core.module.user.model.User;
import com.trucktrack.web.form.RegisterFormBean;

public class UserUtils
{
	public static User createUser(RegisterFormBean formBean)
	{
		User user = new User();
		user.setRefCustomerId(formBean.getRefCountryCode());
		user.setFirstName(formBean.getFirstName());
		user.setLastName(formBean.getLastName());
		user.setUsername(formBean.getUsername());
		user.setPassword(formBean.getPassword());
		user.setTermsAccepted(false);
		Calendar cal = Calendar.getInstance();
		cal.set(2013, 1, 1);
		user.setDeadline(cal.getTime());
		user.setAccess(0);
		
		return user;
	}
}
