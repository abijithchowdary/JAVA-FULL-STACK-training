package com.capg.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertStudent {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		
		cfg.configure();
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction t = session.beginTransaction();
		
		try {
			
			Student s1 = new Student();
			
			s1.setSid(1);
			s1.setSname("Billa");
			s1.setSemail("abijithchowdary@gmail.com");
			s1.setSmobile(903272244);
			
			session.save(s1);
			
			t.commit();
			
			System.out.println("Records inserted sucessfully");
			
		}
		catch(Exception e) {
			t.rollback();
		}
		finally {
			session.close();
		}
	}

}