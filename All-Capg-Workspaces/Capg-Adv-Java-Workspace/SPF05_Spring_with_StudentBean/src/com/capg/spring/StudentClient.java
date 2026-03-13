package com.capg.spring;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentClient {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Stduent Management Portal!");
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext_Dao.xml"); 
		
		StudentDao obj = (StudentDao)factory.getBean("studentDao");
		
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		
		while(flag) {
			
			System.out.println("Select Below Operations!");
			
			System.out.println("1. Add Stduent!");
			
			System.out.println("2. Get Stduent Details!");
			
			System.out.println("3. Remove Student!");
			
			System.out.println("4. Update Student Name!");
			
			System.out.println("5. Exit!");
			
			System.out.println("Enter your choice: ");
			
			int choice = sc.nextInt();
			
			sc.nextLine();
			
			switch(choice) {
			
				case 1:
					
					System.out.print("Enter Name of Student: ");
					String name = sc.nextLine();
					System.out.print("Enter Regno: ");
					int regNo = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter Branch: ");
					String branch = sc.nextLine();
					System.out.print("Enter Email: ");
					String email = sc.nextLine();
					
					StudentBean sb = new StudentBean(name,regNo,branch,email);
					
					obj.save(sb);
					
					break;
				
				case 2:
					
					System.out.print("Enter Student Regno: ");
					
					int regNo1 = sc.nextInt();
					
					StudentBean sb1 = obj.get(regNo1);
							
					if(sb1 == null) {
						System.out.println("No Student Found!");
					}
					else {
						System.out.println(sb1);
					}
					
					break;
					
				case 3:
					
					System.out.print("Enter Student Regno: ");
					
					int regNo2 = sc.nextInt();
					
					int res = obj.removeStudent(regNo2);
					
					if(res == 0) {
						System.out.println("No Student Found to delete!");
					}
					else {
						System.out.println("Student Deleted Successfully!");
					}
					break;
					
				case 4:
					
					System.out.print("Enter Student Regno: ");
					
					int regNo3 = sc.nextInt();
					
					sc.nextLine();
					
					System.out.print("Enter New Name: ");
					
					String newname = sc.nextLine();
					
					int res1 = obj.updateStudentName(regNo3,newname);
					
					if(res1 == 0) {
						System.out.println("No Student Found to Udpate!");
					}
					else {
						System.out.println("Student Name Updated Successfully!");
					}
					
					break;
					
				case 5:
					
					System.out.println("Exiting.....!");
					
					flag = false;
					
					break;
					
				default:
					
					System.out.println("Enter Valid Option!");
			}
			
		}
		
		sc.close();
	}
}
