package com.capg.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class HealthcareAppointmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthcareAppointmentApplication.class, args);
		System.out.println("Healthcare service is now live...");
	}

}
