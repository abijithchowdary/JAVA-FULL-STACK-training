package com.capg.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HealthcarePatientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthcarePatientApplication.class, args);
		System.out.println("Healthcare Patient service is live now...");
	}

}
