package com.capg.Collections;
import java.util.*;

public class ComparatorMethod {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Studentss> list= new ArrayList<>();
		
		System.out.println("Enter number of Students : ");
		int n = sc.nextInt();
		System.out.println("Enter the Data : ");
		for(int i=0;i<n;i++) {
			int id = sc.nextInt();
			sc.nextLine();
			String name = sc.nextLine();
			int age = sc.nextInt();
			list.add(new Studentss(id,name,age));
		}
		
		Collections.sort(list, new Comparing());
		
		System.out.println(list);
		
	}
}
class Comparing implements Comparator<Studentss>{
	public int compare(Studentss s , Studentss a) {
		return s.name.compareTo(a.name);
		
	}
}
class Studentss{
	int id;
	String name;
	int age;
	Studentss(int id,String name,int age){
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public String toString() {
		return "ID : "+id+", Name : "+name+", Age : "+age;
	}
}