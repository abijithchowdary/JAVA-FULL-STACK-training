package com.capg.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Cs100BookEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cs100BookEurekaServerApplication.class, args);
		System.out.println("Eureka Server Started!!!");
	}

}
