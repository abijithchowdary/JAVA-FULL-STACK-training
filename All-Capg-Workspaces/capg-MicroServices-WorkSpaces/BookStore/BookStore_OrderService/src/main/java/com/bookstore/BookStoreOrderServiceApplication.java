package com.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class BookStoreOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreOrderServiceApplication.class, args);
        System.out.println("Order Service Running...");
    }
}