package com.capg.Streams;
import java.util.*;

public class IntermediateOperations {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		List<Student> list = new ArrayList<>();
		
		System.out.println("Enter number of elements : ");
		int n = sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++) {
			int id = sc.nextInt();
			sc.nextLine();
			String name = sc.nextLine();
			int age = sc.nextInt();
			
			list.add(new Student(id,name,age));
		}
		//System.out.println(list);
		
		
		// Filtering in streams
		//list.stream().filter(a -> a.age > 20).forEach(System.out::println);
		
		//map this is to get specified type of data
		//list.stream().map(a -> a.name).forEach(System.out::println);
		
		//sorting (we use compareTo() method when data type is warper class) we use Comparator.comparing(a -> a.id) this method when data type is not a warper class
		//list.stream().sorted(Comparator.comparing(a -> a.id)).forEach(System.out::println);
		
		//Distinct it will eliminate duplicates when data has same hash code when we create new obj for every time we add data it will not remove duplicates when the data is same also
		//list.stream().distinct().forEach(System.out::println);
		
		//limit it will print up to limit value
		//list.stream().limit(2).forEach(System.out::println);
		
		//skip it will print data from skip value
		//list.stream().skip(2).forEach(System.out::println);
		
		
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
		return "Id : " + id + ", Name : "+name + ", age : "+age+ " ||| ";
	}
}