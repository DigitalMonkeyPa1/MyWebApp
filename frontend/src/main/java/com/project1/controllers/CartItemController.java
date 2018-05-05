package com.project1.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project1.models.CartItem;
import com.project1.models.Product;
import com.project1.models.ShippingAddress;
import com.project1.models.User;
import com.project1.services.CartItemService;
import com.project1.services.ProductService;

@Controller
public class CartItemController
{
	@Autowired
	ProductService productService;
	
	@Autowired
	CartItemService cartItemService;
	
	@RequestMapping(value="/cart/addToCart/{id}")
	public String addToCart(@PathVariable int id, @AuthenticationPrincipal Principal principal, @RequestParam int requestedQuantity)
	{
		String email = principal.getName();
		User user = cartItemService.getUser(email);
		Product product = productService.getProduct(id);
		List<CartItem> cartItems = user.getCartItems();
		
		// if cartItem exists update quantity & price else create new one and update
		for(CartItem cartItem:cartItems)
		{
			if(cartItem.getProduct().getId() == id)
			{
				cartItem.setQuantity(requestedQuantity);
				cartItem.setTotalPrice(requestedQuantity * product.getPrice());
				cartItemService.saveOrUpdateCartItem(cartItem);
				return "redirect:/cart/purchaseDetails";
			}
		}
		
		CartItem cartItem = new CartItem();
		cartItem.setQuantity(requestedQuantity);
		cartItem.setTotalPrice(requestedQuantity * product.getPrice());
		cartItem.setUser(user);// FK
		cartItem.setProduct(product);// FK
		
		cartItemService.saveOrUpdateCartItem(cartItem);
		return "redirect:/cart/purchaseDetails";
	}
	
	@RequestMapping(value="/cart/purchaseDetails")
	public String getPurchaseDetails(@AuthenticationPrincipal Principal principal, Model model)
	{
		String email = principal.getName();
		User user = cartItemService.getUser(email); // UserService
		List<CartItem> cartItems = user.getCartItems();
		model.addAttribute("cartItemsAttribute", cartItems);
		return "cart";
	}
	
	@RequestMapping(value="/cart/deleteCartItem/{id}")
	public String removeCartItem(@PathVariable int id)
	{
		cartItemService.removeCartItem(id);
		return "redirect:/cart/purchaseDetails";
	}
	
	@RequestMapping(value="/cart/clearCart")
	public String clearCart(@AuthenticationPrincipal Principal principal)
	{
		String email = principal.getName();
		cartItemService.removeAllCartItemsForUser(email);
		return "redirect:/cart/purchaseDetails";
	}
	
	@RequestMapping(value="/cart/checkOut")
	public ModelAndView doCheckOut(@AuthenticationPrincipal Principal principal, Model model)
	{
		ModelAndView modelAndView = new ModelAndView("checkOut");
		
		String email = principal.getName();
		User user = cartItemService.getUser(email);
		modelAndView.addObject("userAttribute", user);
		//modelAndView.addObject("userNameAttribute", user.getCustomer().getFirstName());
		//modelAndView.addObject("shippingAddressAttribute", user.getCustomer().getShippingAddress());
		
		return modelAndView;
	}
	
	/*
	@RequestMapping(value="/cart/createOrder")// from shippingaddressform.jsp to createOrder method
	public String createOrder(@AuthenticationPrincipal Principal principal, @ModelAttribute ShippingAddress shippingAddress, Model model)
	{
		
		return "redirect:/cart/purchaseDetails";
	}*/
	
}
