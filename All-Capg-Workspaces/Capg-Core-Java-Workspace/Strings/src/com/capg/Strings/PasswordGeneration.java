package com.java.m1;

import java.util.Scanner;

public class PasswordGeneration {
	public static void main(String[] args) {
		
//		String regex = "[A-Z]{4}@10[1-9]|[A-Z]{4}@11[0-5]";
		String regex = "[A-Z]{4}@1(0[1-9]|1[0-5])";
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Username: ");
		String username=sc.next();
		boolean flag = false;
		
		if(username.matches(regex)) {
			flag = true;
		}
		
		if(flag) {
			
			String password="TECH_";
			String st=username.substring(0, 3);
			String end=username.substring(username.length()-2);
			int sum = 0;
			for(int ch:st.toCharArray()) {
				sum+=ch;
			}
			password=password+sum+end;
			System.out.println(username);
			System.out.println(password);
			
		}else {
			System.out.println("Invalid Username");
		}
		
	}
}
