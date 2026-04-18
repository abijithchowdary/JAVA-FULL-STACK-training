package com.capg.springboot.service;

import com.capg.springboot.entity.User;

public interface ILoginService {
	
//	add new user, return saved user
	User addUser(User user);
	
//	remove existing user, return deleted user
	User removeUser(Long userId);
	
//	validate login - check email + password
//	return JWT token if valid
	String validateUser(String email , String password);
	
	User signOut(String userId);
	
	User getUserById(String userId);
	
	User getUserByEmail(String email);
	
}
