/**
 * 
 */
package com.trucktrack.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trucktrack.core.module.cargo.dao.ICargoDAO;
import com.trucktrack.core.module.user.dao.IUserDAO;
import com.trucktrack.web.model.TermsAcceptanceView;

/**
 * Handles and retrieves the login or denied page depending on the URI template
 */
@Controller
@RequestMapping("/auth")
public class LoginController
{
	protected static Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private ICargoDAO cargoDAO;
	
	/**
	 * Handles and retrieves the login JSP page
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(Model model)
	{
		logger.debug("Received request to show login page");

		return "authLogin";
	}
	
	/**
	 * Handles and retrieves the login JSP page
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/failure", method = RequestMethod.GET)
	public String getLoginFailurePage(Model model)
	{
		logger.debug("Received request to show login page");
		
		model.addAttribute("error", "true");
		
		return "authLogin";
	}
	
	@RequestMapping(value = "/terms/{username}", method = RequestMethod.GET)
	public String getTermsPage(Model model, @PathVariable("username") String username)
	{
		logger.debug("Received request to show terms page");
		
		TermsAcceptanceView termsAcceptanceView = new TermsAcceptanceView();
		termsAcceptanceView.setUsername(username);
		model.addAttribute("termsAcceptanceView", termsAcceptanceView);
		
		return "authTerms";
	}
	
	@RequestMapping(value = "/terms", method = RequestMethod.POST)
	public String postTermsPage(Model model, @ModelAttribute("termsAcceptanceView") TermsAcceptanceView termsAcceptanceView)
	{
		logger.debug("Redirect to default page");
		
		userDAO.acceptTerms(termsAcceptanceView.getUsername());
		
		// This will be replaced by default page
//		model.addAttribute("cargos", cargoDAO.getCargos(" 1=1"));
//		return "cargoList";
		
		return "redirect:/cargo/list";
	}

	/**
	 * Handles and retrieves the denied JSP page. This is shown whenever a
	 * regular user tries to access an admin only page.
	 * 
	 * @return the name of the JSP page
	 */
//	@RequestMapping(value = "/denied", method = RequestMethod.GET)
//	public String getDeniedPage() {
//		logger.debug("Received request to show denied page");
//
//		// This will resolve to /WEB-INF/jsp/deniedpage.jsp
//		return "deniedpage";
//	}
}