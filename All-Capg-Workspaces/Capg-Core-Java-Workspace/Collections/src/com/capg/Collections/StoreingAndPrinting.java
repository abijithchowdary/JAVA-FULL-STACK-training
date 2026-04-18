package com.capg.Collections;
import java.util.*;

public class StoreingAndPrinting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Students> list = new ArrayList<>();
		
		//manual data adding
		list.add(new Students(121,"Billa Abijith Chowdary",21,903272244L));
		
		//adding data by user input
		System.out.println("Enter number of students:");
		int n = sc.nextInt();
		sc.nextLine(); // clear buffer

		for(int i=0;i<n;i++){
		    System.out.println("Enter id, name, age, phone:");
		    int id = sc.nextInt();
		    sc.nextLine();       // buffer clear
		    String name = sc.nextLine();
		    int age = sc.nextInt();
		    long phone = sc.nextLong();
		    sc.nextLine();       // buffer clear

		list.add(new Students(id,name,age,phone));
		}
		
		//printing the output by iterator 
		Iterator<Students> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
class Students{
	int id;
	String name;
	int age;
	long phone;
	public Students(int id,String name,int age,long phone){
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	public String toString() {
		return "ID : "+id+", NAME : "+name+", AGE : "+age+", PHONE : "+phone; 
	}
}