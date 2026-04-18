package com.capg.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineShoppingLoginServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineShoppingLoginServiceApplication.class, args);
		System.out.println("OnlineShopping Login service is now running on port 9090...");
	}

}
