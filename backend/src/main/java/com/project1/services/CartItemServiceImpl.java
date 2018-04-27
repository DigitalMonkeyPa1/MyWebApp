package com.project1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project1.dao.CartItemDao;
import com.project1.models.CartItem;
import com.project1.models.User;

@Service
public class CartItemServiceImpl implements CartItemService
{
	@Autowired
	CartItemDao cartItemDao;
	
	public void saveOrUpdateCartItem(CartItem cartItem)
	{
		cartItemDao.saveOrUpdateCartItem(cartItem);
	}

	public void removeCartItem(int id)
	{		
		cartItemDao.removeCartItem(id);
	}

	public User getUser(String email)
	{	
		return cartItemDao.getUser(email);
	}

	public void removeAllCartItemsForUser(String email)
	{		
		cartItemDao.removeAllCartItemsForUser(email);
	}
	
}
