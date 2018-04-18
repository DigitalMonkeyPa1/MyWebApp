package com.project1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.project1.models.Authorities;
import com.project1.models.Cart;
import com.project1.models.Customer;

public class CustomerDaoImpl implements CustomerDao
{
	@Autowired
	private SessionFactory sessionFactory;

	public void registerCustomer(Customer customer)
	{
		Session session = sessionFactory.getCurrentSession();
		
		customer.getUser().setEnabled(true);
		Authorities authorities = new Authorities();
		authorities.setRole("ROLE_USER");
		authorities.setUser(customer.getUser());// FK user_email in authorities
		customer.getUser().setAuthorities(authorities);
		
		Cart cart = new Cart();
		customer.setCart(cart);
		
		session.saveOrUpdate(customer);
	}
	
	
}
