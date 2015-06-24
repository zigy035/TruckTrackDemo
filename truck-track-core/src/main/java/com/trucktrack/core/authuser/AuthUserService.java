package com.trucktrack.core.authuser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.trucktrack.core.module.user.dao.IUserDAO;
import com.trucktrack.core.module.user.model.User;


public class AuthUserService implements UserDetailsService
{
	protected static Logger logger = Logger.getLogger(AuthUserService.class);
	
	private IUserDAO userDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User dbUser = userDAO.getUserByUsername(username);
		
		if (dbUser == null)
		{
			throw new UsernameNotFoundException("User not found");			
		}
				
		UserDetails user = new org.springframework.security.core.userdetails.User(
				dbUser.getUsername(), 
				dbUser.getPassword(), 
				true, 
				true, 
				true, true, getAuthorities(1));
		
		return user;
	}

	public Collection<GrantedAuthority> getAuthorities(Integer access)
	{
		// Create a list of grants for this user
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

		// All users are granted with ROLE_USER access
		// Therefore this user gets a ROLE_USER by default
		logger.debug("Grant ROLE_USER to this user");
		authList.add(new SimpleGrantedAuthority("ROLE_USER"));

		// Check if this user has admin access
		// We interpret Integer(1) as an admin user
		if (access.compareTo(1) == 0) {
			// User has admin access
			logger.debug("Grant ROLE_ADMIN to this user");
			authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}

		// Return list of granted authorities
		return authList;
	}

	// Inject User DAO
	public void setUserDAO(IUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}

}
