package com.project1.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	
}
