package com.capg.java.java;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductClient {
	
	//Step - 1
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml"); //Step-2
		
		ProductService p1 = (ProductService) factory.getBean("productService1"); //Step-3
		 
		p1.allProducts(); //Step-9
		
		ProductService p2 = (ProductService) factory.getBean("productService2"); //Step-11
		
		p2.allProducts(); //Step-17
		
	}
}