package com.trucktrack.web.util;

import java.util.Calendar;

import com.trucktrack.core.module.user.model.User;
import com.trucktrack.web.model.CustomerView;

public class UserUtils
{
	public static User createUser(CustomerView customerView)
	{
		User user = new User();
		user.setRefCustomerId(customerView.getRefCountryCode());
		user.setFirstName(customerView.getFirstName());
		user.setLastName(customerView.getLastName());
		user.setUsername(customerView.getUsername());
		user.setPassword(customerView.getPassword());
		user.setTermsAccepted(false);
		Calendar cal = Calendar.getInstance();
		cal.set(2013, 1, 1);
		user.setDeadline(cal.getTime());
		user.setAccess(0);
		
		return user;
	}
}
