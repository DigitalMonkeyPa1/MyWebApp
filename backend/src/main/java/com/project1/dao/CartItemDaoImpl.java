package com.project1.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project1.models.CartItem;
import com.project1.models.User;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	public void saveOrUpdateCartItem(CartItem cartItem)
	{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);// to insert a new product, update quantity and totalprice for already existing cartitem
	}

	public void removeCartItem(int id)
	{
		Session session = sessionFactory.getCurrentSession();
		CartItem cartitem = (CartItem) session.get(CartItem.class, id);
		session.delete(cartitem);
	}

	public void removeAllCartItemsForUser(String email)
	{
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, email);
		List<CartItem> cartItems = user.getCartItems();
		for(CartItem cartItem:cartItems)
		{
			session.delete(cartItem);
		}
	}
	
	public User getUser(String email)
	{
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, email);
		return user;
	}
	
	//public CustomerOrder createOrder(User user)
	//{
	//	
	//}
	
}
