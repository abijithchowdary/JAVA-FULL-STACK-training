package com.capg.assessment.controller;

import java.util.List;
import java.util.Scanner;

import com.capg.assessment.bean.TransactionBean;
import com.capg.assessment.service.BankAccountService;

public class BankAccountController {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		BankAccountService obj = new BankAccountService();
		
		System.out.println("Welcome To ABC Bank!");
		
		boolean flag = true;
		
		while(flag) {
			
			
			System.out.println("Our Services!");
			
			System.out.println("1. Create Account!");
			System.out.println("2. Show Account Balance!");
			System.out.println("3. Deopist Money!");
			System.out.println("4. Withdraw Amount!");
			System.out.println("5. Fund Transfer!");
			System.out.println("6. Account Statement!");
			System.out.println("7. Exit!");
			
			System.out.println("Please choice an option: ");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			
			case 1:
				
				System.out.println("Enter Account Number: ");
				
				long accno = sc.nextLong();
				
				sc.nextLine();
				
				System.out.println("Enter Holder Name: ");
				
				String hname = sc.nextLine();
				
				System.out.println("Enter Mobile Number: ");
				
				long mnum = sc.nextLong();
				
				System.out.println("Enter initial Balance min(1000.00): ");
				
				double bal = sc.nextDouble();
				
				obj.addAccount(accno,hname,mnum,bal);
				
				break;
				
			case 2:
				
				System.out.println("Enter Account Number: ");
				long accnum = sc.nextLong();
				
				System.out.println("Current Balance: " + obj.getBalance(accnum));
				
				break;
				
			case 3:
				
				System.out.println("Enter Account Number: ");
				long ano = sc.nextLong();
				
				System.out.println("Enter amount to deposit: ");
				double amount = sc.nextDouble();
				
				obj.depositAmount(ano,amount);
				
				break;
			
			case 4:
				
				System.out.println("Enter Account Number: ");
				long a1no = sc.nextLong();
				
				System.out.println("Enter amount to withdraw: ");
				double wamount = sc.nextDouble();
				
				obj.withdrawAmount(a1no,wamount);
				
				break;
				
			case 5:
				
				System.out.println("Enter Account Number to transfer from: ");
				long a2no = sc.nextLong();
				System.out.println("Enter Account Number to transfer to: ");
				long a3no = sc.nextLong();
				
				System.out.println("Enter Amount to transfer: ");
				double a1 = sc.nextDouble();
				
				obj.transferAmount(a2no,a3no,a1);
				
				break;
				
			case 6:
				
				System.out.println("Enter Account Number for statement: ");
				long ac4no = sc.nextLong();
				
				List<TransactionBean> list = obj.getStatements(ac4no);
				
				if(list != null) {
				
					for(TransactionBean bean : list) {
						
						System.out.println("Transaction Id: " + bean.getTransId() + " -> " + bean.getTrans() + " on " + bean.getDate());
					}
				
				}
				
				break;
				
			case 7:
				flag = false;
				break;
			default:
				System.out.println("Please choise correct option!");
				break;
				
			}
			
		}
		sc.close();
	}
}
