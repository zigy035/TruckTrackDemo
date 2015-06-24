package com.trucktrack.core.module.user.dao.impl;

import com.trucktrack.core.common.dao.CommonDAO;
import com.trucktrack.core.module.user.dao.IUserDAO;
import com.trucktrack.core.module.user.model.User;

public class UserDAO extends CommonDAO implements IUserDAO
{

	@Override
	public User getUserByUsername(String username)
	{		
		User user = (User) getSqlMapClientTemplate().queryForObject("getUserByUsername", username);
		
		return user;
	}

	@Override
	public void acceptTerms(String username)
	{
		getSqlMapClientTemplate().update("acceptTerms", username);
	}

	@Override
	public void addUser(User user)
	{
		getSqlMapClientTemplate().insert("addUser", user);
	}
	
}
