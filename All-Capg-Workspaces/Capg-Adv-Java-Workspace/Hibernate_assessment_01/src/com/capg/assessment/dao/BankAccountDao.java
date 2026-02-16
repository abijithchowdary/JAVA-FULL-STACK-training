package com.capg.assessment.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.capg.assessment.bean.AccountBean;
import com.capg.assessment.bean.TransactionBean;

public class BankAccountDao {
	
	
	AnnotationConfiguration cfg = new AnnotationConfiguration().configure("hibernate_annotation.cfg.xml");
	SessionFactory factory = cfg.buildSessionFactory();
	
	Session session= null;
	
	
	public boolean isAccountExists(long accno) {
		
		session = factory.openSession();
		
		AccountBean bean = (AccountBean) session.get(com.capg.assessment.bean.AccountBean.class,accno);
		
		session.close();
		
		if(bean == null)return false;
		
		return true;
	}

	
	public void addToDB(AccountBean ab) {
		
		session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.save(ab);
			
			TransactionBean tb = new TransactionBean();
			
			tb.setAccNo(ab.getAccNo());
			tb.setTrans("Create account with initial Balance " + ab.getBalance());
			tb.setDate(Date.valueOf(LocalDate.now()));
			
			session.save(tb);
			
			t.commit();
			
			System.out.println("Account Created Successfully!");
		}
		catch(Exception e) {
			t.rollback();
			System.out.println("Failed Adding Account!");
		}
		finally {
			session.close();
		}
	}

	public double getBalance(long accno) {
		
		session = factory.openSession();
		
		AccountBean bean = (AccountBean) session.get(com.capg.assessment.bean.AccountBean.class,accno);
		
		session.close();
		
		return bean.getBalance();
		
	}

	public void depositAmount(long ano, double amount) {
		
		session = factory.openSession();
		
		AccountBean bean = (AccountBean) session.get(com.capg.assessment.bean.AccountBean.class,ano);
		
		session.close();
		
		bean.setBalance(bean.getBalance() + amount);
		
		session = factory.openSession();
		Transaction t = session.beginTransaction();
		TransactionBean tb = new TransactionBean();
		
		try {
		
			session.update(bean);
			
			tb.setAccNo(bean.getAccNo());
			tb.setTrans("Amount Deposited -> " + amount);
			tb.setDate(Date.valueOf(LocalDate.now()));
			
			session.save(tb);
			t.commit();
			System.out.println("Amount Deposited Sucessfully!");
		}
		catch(Exception e) {
			t.rollback();
			System.out.println("Deposit Failed!");
		}
		finally {
			session.close();
		}
	}

	public void withdramAmount(long a1no, double wamount) {
		
		session = factory.openSession();
		
		AccountBean bean = (AccountBean) session.get(com.capg.assessment.bean.AccountBean.class,a1no);
		
		session.close();
		
		bean.setBalance(bean.getBalance() - wamount);
		
		session = factory.openSession();
		Transaction t = session.beginTransaction();
		TransactionBean tb = new TransactionBean();
		
		try {
		
			session.update(bean);
			
			tb.setAccNo(bean.getAccNo());
			tb.setTrans("Amount Withdrawn -> " + wamount);
			tb.setDate(Date.valueOf(LocalDate.now()));
			
			session.save(tb);
			
			t.commit();
			
			System.out.println("Amount Withdrawn Sucessfully!");
		}
		catch(Exception e) {
			t.rollback();
			System.out.println("Withdraw Failed!");
		}
		finally {
			session.close();
		}
	}

	public void transferAmount(long a2no, long a3no, double a1) {
		
		session = factory.openSession();
		
		AccountBean bean1 = (AccountBean) session.get(com.capg.assessment.bean.AccountBean.class,a2no);
		
		AccountBean bean2 = (AccountBean) session.get(com.capg.assessment.bean.AccountBean.class,a3no);
	
		session.close();
		
		bean1.setBalance(bean1.getBalance() - a1);
		bean2.setBalance(bean2.getBalance() + a1);
		
		session = factory.openSession();
		Transaction t = session.beginTransaction();
		TransactionBean tb = new TransactionBean();
		
		try {
		
			session.update(bean1);
			session.update(bean2);
			
			tb.setAccNo(bean1.getAccNo());
			tb.setTrans("Amount -> " + a1 + " Transferred to " + bean2.getAccNo());
			tb.setDate(Date.valueOf(LocalDate.now()));
			session.save(tb);
			t.commit();
			System.out.println("Amount Transferred Sucessfully!");
		}
		catch(Exception e) {
			t.rollback();
			System.out.println("Transfering Failed!");
		}
		finally {
			session.close();
		}
	}


	@SuppressWarnings("unchecked")
	public List<TransactionBean> getStatement(long ac4no) {
		
		session = factory.openSession();
		
		List<TransactionBean> statements = (List<TransactionBean>) session
				.createQuery("from TransactionBean where AccountNumber = :no")
		        .setParameter("no", ac4no)
		        .list();
		
		session.close();
		
		return statements;

	}	
	
}
