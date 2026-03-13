package com.capg.customer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {
	
	@Id
	private int customerId;
	private String cname;
	private String email;
	private String phone;
	
	public Customer() {
		
	}
	
	public Customer(int customerId, String cname, String email, String phone) {
		super();
		this.customerId = customerId;
		this.cname = cname;
		this.email = email;
		this.phone = phone;
	}

	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "customer [customerId=" + customerId + ", cname=" + cname + ", email=" + email + ", phone=" + phone
				+ "]";
	}
}
