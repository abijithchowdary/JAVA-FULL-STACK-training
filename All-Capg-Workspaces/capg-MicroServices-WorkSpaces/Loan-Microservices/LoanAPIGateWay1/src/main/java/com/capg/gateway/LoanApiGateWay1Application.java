package com.capg.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LoanApiGateWay1Application {

	public static void main(String[] args) {
		SpringApplication.run(LoanApiGateWay1Application.class, args);
		System.out.println("GateWay Server Started!!!!");
	}

}
