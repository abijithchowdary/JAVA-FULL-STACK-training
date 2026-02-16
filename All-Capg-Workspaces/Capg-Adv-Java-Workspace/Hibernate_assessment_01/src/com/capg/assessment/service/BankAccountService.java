package com.capg.assessment.service;

import java.util.List;

import com.capg.assessment.bean.AccountBean;
import com.capg.assessment.bean.TransactionBean;
import com.capg.assessment.dao.BankAccountDao;

public class BankAccountService {
	
	BankAccountDao obj = new BankAccountDao();
	
	public void addAccount(long accno, String hname, long mnum, double bal) {
		
		AccountBean ab = new AccountBean();
		
		ab.setAccNo(accno);
		ab.setHolderName(hname);
		ab.setMobile(mnum);
		ab.setBalance(bal);
		
		obj.addToDB(ab);
	}
	
	public double getBalance(long accno) {
		
		if(obj.isAccountExists(accno)) {
			return obj.getBalance(accno);
		}
		else {
			System.out.println("Account doesn't exist!");
			return -1000.0;
		}
	}

	public void depositAmount(long ano, double amount) {
		
		if(obj.isAccountExists(ano)) {
			obj.depositAmount(ano,amount);
		}
		else {
			System.out.println("Account doesn't exist!");
		}
	}

	public void withdrawAmount(long a1no, double wamount) {
		
		if(obj.isAccountExists(a1no)) {
			
			if(obj.getBalance(a1no) - wamount < 0) {
				
				System.out.println("Limited Balance. Can't Withdraw entered amount!");
			}
			else {
				obj.withdramAmount(a1no,wamount);
			}
		}
		else {
			System.out.println("Account doesn't exist!");
		}
	}

	public void transferAmount(long a2no, long a3no, double a1) {
		
		if(!obj.isAccountExists(a2no)) {
			System.out.println("Sender account doesn't exist!");
			return;
		}
		if(!obj.isAccountExists(a3no)) {
			System.out.println("Receiver account doesn't exist!");
			return;
		}
		if(obj.getBalance(a2no) - a1 < 0) {
			System.out.println("Limited Balance. Can't able to transfer amount!");
		}
		else {
			obj.transferAmount(a2no,a3no,a1);
		}
	}

	public List<TransactionBean> getStatements(long ac4no) {
		
		if(!obj.isAccountExists(ac4no)) {
			System.out.println("Account doesn't exist!");
			return null;
		}
		else {
			return obj.getStatement(ac4no);
		}
	}

}
