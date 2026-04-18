package com.capg.springboot.feignclient;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capg.springboot.dto.UserResponse;

@FeignClient(name = "LOGIN-SERVICE" , url = "${login.service.url}")
public interface LoginFeignClient {
	
	@PostMapping("/login/addUser")
	UserResponse createUser(@RequestBody Map<String , String> userDetails);
	
	@GetMapping("/login/getUserByUserId/{userId}")
	UserResponse getUserByid(@PathVariable("userId") Long id);
	
	@GetMapping("/login/getUserByEmail/{email}")
	UserResponse getUserByEmail(@PathVariable("email") String email);
}
