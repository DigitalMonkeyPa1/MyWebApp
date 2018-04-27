package com.project1.dao;

import com.project1.models.CartItem;
import com.project1.models.User;

public interface CartItemDao
{
	void saveOrUpdateCartItem(CartItem cartItem);
	void removeCartItem(int id);
	void removeAllCartItemsForUser(String email);
	User getUser(String email);
	//ToDo:
	//CustomerOrder customerOrder;
}
