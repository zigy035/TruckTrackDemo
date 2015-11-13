package com.trucktrack.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;

import com.trucktrack.core.module.user.dao.IUserDAO;
import com.trucktrack.core.module.user.model.User;

public class TermsAcceptanceFilter implements Filter
{
	private IUserDAO userDAO;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) 
			throws IOException, ServletException 
	{
		String path = ((HttpServletRequest) request).getRequestURI();
		String contextPath = ((HttpServletRequest) request).getContextPath();
		
		if (path != null && 
				(path.contains("homepage") || path.contains("auth") || path.contains("terms") || path.contains("register") 
				 || path.contains("public") || path.contains("passwordForgot") || path.contains("styles")) )
		{
			filterChain.doFilter(request, response);
		}
		else
		{
			String username =  (String)SecurityContextHolder.getContext().getAuthentication().getName();
			User user = userDAO.getUserByUsername(username);
			if (user == null)
			{
				((HttpServletResponse) response).sendRedirect(contextPath + "/auth/login");
			}
			else if (user.getTermsAccepted())
			{
				filterChain.doFilter(request, response);					
			}
			else
			{
				((HttpServletResponse) response).sendRedirect(contextPath + "/auth/terms/" + username);	
			}
			
		}		
	}

	@Override
	public void init(FilterConfig config) throws ServletException
	{
		
	}
	
	@Override
	public void destroy()
	{
		
	}

	// Inject User DAO
	public void setUserDAO(IUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}

}
