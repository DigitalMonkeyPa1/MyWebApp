package com.project1.services;

import com.project1.models.CartItem;
import com.project1.models.User;

public interface CartItemService
{
	void saveOrUpdateCartItem(CartItem cartItem);
	void removeCartItem(int id);
	void removeAllCartItemsForUser(String email);
	User getUser(String email);
	//CustomerOrder createCustomerOrder(User user);
	
}
