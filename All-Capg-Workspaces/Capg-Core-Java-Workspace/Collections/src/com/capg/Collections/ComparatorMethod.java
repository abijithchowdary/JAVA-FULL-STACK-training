package com.capg.Collections;
import java.util.*;

public class ComparatorMethod {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Student> list= new ArrayList<>();
		
		System.out.println("Enter number of Students : ");
		int n = sc.nextInt();
		System.out.println("Enter the Data : ");
		for(int i=0;i<n;i++) {
			int id = sc.nextInt();
			sc.nextLine();
			String name = sc.nextLine();
			int age = sc.nextInt();
			list.add(new Student(id,name,age));
		}
		
		Collections.sort(list, new Comparing());
		
		System.out.println(list);
		
	}
}
class Comparing implements Comparator<Student>{
	public int compare(Student s , Student a) {
		return s.name.compareTo(a.name);
		
	}
}
class Student{
	int id;
	String name;
	int age;
	Student(int id,String name,int age){
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public String toString() {
		return "ID : "+id+", Name : "+name+", Age : "+age;
	}
}