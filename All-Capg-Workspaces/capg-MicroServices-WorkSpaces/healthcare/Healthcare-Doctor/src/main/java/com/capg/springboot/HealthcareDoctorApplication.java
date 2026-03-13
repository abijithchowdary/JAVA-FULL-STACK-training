package com.capg.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HealthcareDoctorApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthcareDoctorApplication.class, args);
		System.out.println("Healthcare doctor service is now live...");
	}

}
