package com.capg.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.springboot.entity.User;
import com.capg.springboot.service.LoginServiceImpl;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {
	
	@Autowired
    private LoginServiceImpl loginService;
	
	@PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User savedUser = loginService.addUser(user);
        // 201 CREATED is the correct status for successful resource creation
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
	
	
	@PostMapping("/validateUser")
    public ResponseEntity<String> validateUser(@RequestBody User user) {
        String token = loginService.validateUser(
            user.getEmail(),
            user.getPassword()
        );
        // 200 OK with JWT token in body
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
	
	
	@DeleteMapping("/removeUser/{userId}")
    public ResponseEntity<User> removeUser(@PathVariable Long userId) {
        User removedUser = loginService.removeUser(userId);
        return new ResponseEntity<>(removedUser, HttpStatus.OK);
    }
	
	
	@PutMapping("/signOut/{userId}")
    public ResponseEntity<String> signOut(@PathVariable Long userId) {
        loginService.signOut(userId);
        return new ResponseEntity<>(
            "User " + userId + " signed out successfully",
            HttpStatus.OK
        );
    }
	
	
	@GetMapping("/getUserByUserId/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = loginService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
	
	
	@GetMapping("/getUserByEmail/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = loginService.getUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
	
	
}
