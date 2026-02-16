package com.capg.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class Employee_Client {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure("hibernate_annotation.cfg.xml").buildSessionFactory();
		
		Session  session = sessionFactory.openSession();
		
		Transaction txn = session.beginTransaction();
		
		try {
			
			Employee employee = new Employee();
			employee.setFirstName("Abijith Chowdary");
			employee.setLastName("Billa");
			
			employee.setSalary(6000);
			
			session.save(employee);
			
			txn.commit();
		}
		catch(HibernateException e) {
			
			txn.rollback();
			
			System.out.println("exception while creating employee " + e);
			
			e.printStackTrace();
		}
		finally {
			
			session.close();
		}
	}

}