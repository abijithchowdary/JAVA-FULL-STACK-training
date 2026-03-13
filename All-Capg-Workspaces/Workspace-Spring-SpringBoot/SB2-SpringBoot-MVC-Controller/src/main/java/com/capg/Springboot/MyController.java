package com.capg.Springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@RequestMapping("login.spring")
	public String loginValid() {
		return  "Welcome to SpringBoot Application";
	}
	
	@RequestMapping("ram.spring")
	public String ramValid() {
		return "Welcome to SpringBoot Application Hello Ram";
	}
}