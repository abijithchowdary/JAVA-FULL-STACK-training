package com.cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
	
		Student student = new Student();
			
		student.setName("billa abijithc chowdary");
		
		Address homeAddress = new Address();
		
		homeAddress.setStreet("vajralapeta");
		homeAddress.setCity("penukonda");
		homeAddress.setState("Andra Pradesh");
		homeAddress.setZipCode("515110");
		//inject address into student
		student.setAddress(homeAddress);
		
		em.persist(student);
		//em.persist(homeAddress);
		em.flush();   // forces INSERT immediately
		em.getTransaction().commit();
		
		System.out.println("Added one student with address to database.");
		
		
				
				
				System.out.println(homeAddress.getCity());
								
				System.out.println(" student  State  address : "+student.getAddress().getState());
				System.out.println(" student  City  address : "+student.getAddress().getCity());
				System.out.println(" student  Street  address : "+student.getAddress().getStreet());
				System.out.println(" student  ZipCode  address : "+student.getAddress().getZipCode());
		em.close();
		factory.close();
	}
}
