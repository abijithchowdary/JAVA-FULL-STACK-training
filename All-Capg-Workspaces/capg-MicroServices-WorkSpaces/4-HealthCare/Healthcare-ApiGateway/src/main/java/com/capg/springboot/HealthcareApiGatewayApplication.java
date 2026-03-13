package com.capg.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HealthcareApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthcareApiGatewayApplication.class, args);
		System.out.println("Healthcare API Gateway service is now live...");
	}

}
