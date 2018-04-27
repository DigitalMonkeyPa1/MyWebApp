package com.project1.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User
{
	@Id
	private String email;
	private String password;
	private boolean enabled;
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL) // mapped by entity name //cascade=CascadeType.ALL => here not needed
	private Customer customer;
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL) // mapped by entity name
	private Authorities authorities;
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private List<CartItem> cartItems;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Authorities getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Authorities authorities) {
		this.authorities = authorities;
	}
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
}
