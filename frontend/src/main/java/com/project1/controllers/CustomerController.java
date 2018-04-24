package com.project1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project1.models.Customer;
import com.project1.services.CustomerService;

@Controller
public class CustomerController
{
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customerRegistrationForm")
	public ModelAndView getCustomerRegistrationForm()
	{
		return new ModelAndView("registerCustomerForm", "customerAttribute", new Customer());
	}
	
	@RequestMapping("/registerCustomer")
	public String registerCustomer(@ModelAttribute Customer customer)
	{
		customerService.registerCustomer(customer);
		return "login";
	}
}
