package com.trucktrack.core.module.user.dao;

import com.trucktrack.core.module.user.model.User;

public interface IUserDAO
{
	public User getUserByUsername(String username);
	
	public void acceptTerms(String username);
	
	public void addUser(User user);
	
}
