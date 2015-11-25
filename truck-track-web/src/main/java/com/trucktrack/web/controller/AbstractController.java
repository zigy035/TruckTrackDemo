package com.trucktrack.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.trucktrack.core.module.user.dao.IUserDAO;
import com.trucktrack.core.module.user.model.User;
import com.trucktrack.web.util.CountryUtils;

public abstract class AbstractController {
	
	@Autowired
	protected IUserDAO userDAO;
	
	@ModelAttribute("countryCodes")
	public List<String> getSupportedStoreLocations()
	{
	    return CountryUtils.getCountryCodes();
	}
	
	protected User getLoggedUser()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName(); //get logged in username
	    User user = userDAO.getUserByUsername(username);
		return user;
	}
	
}
