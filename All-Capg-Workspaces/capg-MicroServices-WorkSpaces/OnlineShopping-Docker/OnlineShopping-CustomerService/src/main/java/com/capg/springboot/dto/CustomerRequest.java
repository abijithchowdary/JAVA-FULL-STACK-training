package com.capg.springboot.dto;

//This class represents what the CLIENT SENDS in request body
//when registering a new customer
//
//Why a separate class instead of using Customer entity directly?
//Because the request contains email + password + role
//which belong to Login Service — NOT in Customer entity
//Customer entity only has customerId, firstName, etc.
//So we need a separate class that combines BOTH
//Login details + Customer profile details in one request

public class CustomerRequest {

	// These go to Login Service via FeignClient
	private String email;
	private String password;
	private String role;

	// These stay in Customer Service
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String city;
	private String pincode;

	public CustomerRequest() {
	}

	// Getters
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
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

	public String getCity() {
		return city;
	}

	public String getPincode() {
		return pincode;
	}

	// Setters
	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
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

	public void setCity(String city) {
		this.city = city;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
