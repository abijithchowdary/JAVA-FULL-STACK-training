package com.capg.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.capg.springboot.dao.UserRepository;
import com.capg.springboot.entity.User;
import com.capg.springboot.exceptions.InvalidCredentialsException;
import com.capg.springboot.exceptions.UserAlreadyExistsException;
import com.capg.springboot.exceptions.UserNotFoundException;
import com.capg.springboot.security.JwtUtil;

@Service
public class LoginServiceImpl {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	public User addUser(User user) {
//		check userId already exist or not
		if(userRepository.existsByUserId(user.getUserId())) {
			throw new UserAlreadyExistsException(
                "User already exists with ID: " + user.getUserId()
            );
		}
		
//		check email
		if(userRepository.existsByEmail(user.getEmail())) {
			throw new UserAlreadyExistsException(
                "Email already registered: " + user.getEmail()
            );
		}
		
//		validate role
		if (!user.getRole().equals("ADMIN") && !user.getRole().equals("CUSTOMER")) {
            throw new IllegalArgumentException(
                "Role must be ADMIN or CUSTOMER"
            );
        }
		
		// Checks if email contains @ symbol at minimum
        if (!user.getEmail().contains("@")) {
            throw new IllegalArgumentException(
                "Invalid email format"
            );
        }
        
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        
        return userRepository.save(user);
	}
	
	
	public String validateUser(String email , String password) {
//		first find user by email
		Optional<User> optionalUser = userRepository.findByEmail(email);
		
		User existingUser = optionalUser.orElseThrow(() -> 
			new UserNotFoundException(
                "No account found with email: " + email
            )
		);
		
//		check password
		boolean passwordMatch = passwordEncoder.matches(password, existingUser.getPassword());
		
		if (!passwordMatch) {
            throw new InvalidCredentialsException(
                "Incorrect password"
            );
        }
		
		return jwtUtil.generateToken(existingUser.getUserId(), existingUser.getRole());
	}
	
	
	public User removeUser(Long userId) {
		User user = userRepository.findByUserId(userId)
            .orElseThrow(() ->
                new UserNotFoundException("User not found: " + userId)
            );
        userRepository.deleteById(userId);
        return user;
	}
	
	public User signOut(Long userId) {
		return userRepository.findByUserId(userId)
            .orElseThrow(() ->
                new UserNotFoundException("User not found: " + userId)
            );
	}
	
	public User getUserById(Long userId) {
		return userRepository.findByUserId(userId)
            .orElseThrow(() ->
                new UserNotFoundException("User not found: " + userId)
            );
	}
	
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email)
            .orElseThrow(() ->
                new UserNotFoundException("User not found: " + email)
            );
	}
}
