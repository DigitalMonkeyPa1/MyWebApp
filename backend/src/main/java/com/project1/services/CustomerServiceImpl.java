package com.project1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.dao.CustomerDao;
import com.project1.models.Customer;

@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerDao customerDao;
	
	public void registerCustomer(Customer customer)
	{
		customerDao.registerCustomer(customer);
	}
	
}
