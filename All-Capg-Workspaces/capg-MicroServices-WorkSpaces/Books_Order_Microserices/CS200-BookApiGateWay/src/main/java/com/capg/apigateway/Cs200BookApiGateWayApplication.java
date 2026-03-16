package com.capg.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Cs200BookApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cs200BookApiGateWayApplication.class, args);
		System.out.println("Api Gate Way Started!!!!");
	}

}
