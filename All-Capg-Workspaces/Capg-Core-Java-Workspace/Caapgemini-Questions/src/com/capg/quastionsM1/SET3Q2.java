package com.capg.quastionsM1;
import java.util.*;

public class SET3Q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LibraryManagement lb = new LibraryManagement();
		System.out.println("Enter number of actions you wanna perform : ");
		int n = sc.nextInt();
		while(n-- >= 0) {
			String data = sc.nextLine();
			String[] parts = data.split(" ");
			String cmd = parts[0];
			switch(cmd) {
			case "ADD": lb.addMember(parts[1]);break;
			case "ImposeFine": lb.imposeFine(parts[1],Integer.parseInt(parts[2]));break;
			case "PayFine": lb.payFine(parts[1],Integer.parseInt(parts[2]));break;
			case "GetDetails": System.out.println(lb.result(parts[1]));break;
			}
		}
	}
}
class LibraryManagement{
	Map<String,int[]> student = new LinkedHashMap<>();
	
	public void addMember(String member) {
		student.putIfAbsent(member,new int[]{0,0,0});
	}
	
	public void imposeFine(String member,int amount) {
		int[] data = student.get(member);
		if(data != null) {
			data[0] += amount;
			data[1] += amount;
		}
	}
	
	public void payFine(String member,int amount) {
		int[] data = student.get(member);
		int totalAmount = Math.min(data[0], amount);
		if(data != null) {
			data[0] -= totalAmount;
			data[2] += totalAmount;
		}
	}
	
	public String result(String member) {
		int[] data = student.get(member);
		if(data == null) {
			return "No Such Member found";
		}
		return member+" Remaining fine : "+data[0]+" Total Impposed : "+data[1]+" Total payed : "+data[2]+" \n";
	}
}