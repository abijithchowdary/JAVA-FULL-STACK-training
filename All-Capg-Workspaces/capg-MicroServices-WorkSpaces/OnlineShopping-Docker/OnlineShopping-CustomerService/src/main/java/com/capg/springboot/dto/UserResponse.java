package com.capg.springboot.dto;

//This class represents the User object
//that comes back from Login Service as JSON response
//It is NOT an @Entity — it is just a plain Java class
//used to capture the JSON response from FeignClient call

//Why do we need this?
//When FeignClient calls Login Service GET /login/getUser/1
//Login Service returns JSON like:
//{ "userId": 1, "email": "john@gmail.com", "role": "CUSTOMER" }
//FeignClient needs a Java class to map this JSON into
//That is exactly what this class does

public class UserResponse {

	private Long userId;
	private String email;
	private String password;
	private String role;

	public UserResponse() {
	}

	public Long getUserId() {
		return userId;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
