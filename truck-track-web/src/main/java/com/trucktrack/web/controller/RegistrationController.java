package com.trucktrack.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trucktrack.core.module.customer.model.Customer;
import com.trucktrack.core.module.customer.service.ICustomerService;
import com.trucktrack.core.module.user.model.User;
import com.trucktrack.web.form.RegisterFormBean;
import com.trucktrack.web.util.CountryUtils;
import com.trucktrack.web.util.CustomerUtils;
import com.trucktrack.web.util.UserUtils;
import com.trucktrack.web.validator.CustomerValidator;

@Controller
@RequestMapping(value = "/register")
public class RegistrationController 
{
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private CustomerValidator customerValidator;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private VelocityEngine velocityEngine;

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String createForm(Model model)
	{
		model.addAttribute("countryCodes", CountryUtils.getCountryCodes());
		model.addAttribute("registerFormBean", new RegisterFormBean());
		return "registrationForm";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String create(Model model, RegisterFormBean registerFormBean, BindingResult result)
	{
		customerValidator.validate(registerFormBean, result);
		if (result.hasErrors())
		{
			model.addAttribute("countryCodes", CountryUtils.getCountryCodes());
			model.addAttribute("registerFormBean", registerFormBean);
			return "registrationForm";
		}
		
		final Customer customer = CustomerUtils.createCustomer(registerFormBean);
		final User user = UserUtils.createUser(registerFormBean); 
		
		customerService.register(customer, user);
		model.addAttribute("user", user);
		
//		sendConfirmationEmail(customer, user);
		
		return "confirmRegistration";
	}
	
	private void sendConfirmationEmail(final Customer customer, final User user) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(customer.getEmail());
                message.setFrom("office@westum.com");			// could be parameterized...
                message.setSubject("Welcome to TruckTrack"); 	// could be parameterized...
                Map model = new HashMap();
                model.put("customer", customer);
                model.put("user", user);
                String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "mail-template/registration-confirmation.vm", model);
                message.setText(text, true);
            }
        };
        mailSender.send(preparator);
    }
	
}
