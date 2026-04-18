package com.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BookStoreBookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreBookServiceApplication.class, args);
		System.out.println("Book Service is running...");
	}

}
