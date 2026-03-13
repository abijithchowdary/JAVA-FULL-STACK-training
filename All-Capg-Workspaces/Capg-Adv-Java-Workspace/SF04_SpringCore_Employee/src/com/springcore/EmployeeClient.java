package com.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeClient {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		EmployeeService e1 = (EmployeeService) factory.getBean("e1");
		e1.displayDetails();
		EmployeeService e2 = (EmployeeService) factory.getBean("e2");
		e2.displayDetails();
		EmployeeService e3 = (EmployeeService) factory.getBean("e3");
		e3.displayDetails();
		
		
		factory.close();
		
	}

}
