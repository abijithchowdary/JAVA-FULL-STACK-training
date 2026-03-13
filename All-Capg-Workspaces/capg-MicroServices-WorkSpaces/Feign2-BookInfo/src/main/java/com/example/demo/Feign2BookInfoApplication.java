package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Feign2BookInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Feign2BookInfoApplication.class, args);
		System.out.println("Book Info Server started");
	}

}
