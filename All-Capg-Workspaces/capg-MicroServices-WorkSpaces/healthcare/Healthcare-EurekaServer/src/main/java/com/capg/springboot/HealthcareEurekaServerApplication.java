package com.capg.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HealthcareEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthcareEurekaServerApplication.class, args);
		System.out.println("HealthCare eureka server is live now...");
	}

}
