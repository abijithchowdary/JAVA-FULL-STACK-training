package com.capg.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.capg.springboot.feignclient")
public class OnlineShoppingCustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineShoppingCustomerServiceApplication.class, args);
		System.out.println("OnlineShopping Customer service is now running on port 9091...");	}

}
