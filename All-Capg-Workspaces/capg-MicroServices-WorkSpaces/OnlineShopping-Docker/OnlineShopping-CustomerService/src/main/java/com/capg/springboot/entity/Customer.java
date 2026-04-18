package com.capg.springboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String mobileNumber;

	// Same email as Login Service
	// unique = true — one email = one customer profile
	@Column(nullable = false, unique = true)
	private String email;

	private String city;

	private String pincode;

	// This is the LINK to Login Service
	// Stores the userId returned by Login Service after registration
	// NOT a @ManyToOne — just a plain Long value
	// Because Login Service is a SEPARATE microservice
	// We cannot do JPA joins across different services
	@Column(nullable = false)
	private Long userId;

	public Customer() {
	}

	public Customer(String firstName, String lastName, String mobileNumber, String email, String city, String pincode,
			Long userId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.city = city;
		this.pincode = pincode;
		this.userId = userId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getCity() {
		return city;
	}

	public String getPincode() {
		return pincode;
	}

	public Long getUserId() {
		return userId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Customer{customerId=" + customerId + ", name=" + firstName + " " + lastName + ", email=" + email
				+ ", userId=" + userId + "}";
	}
}