package com.capg.Collections;
import java.util.*;

public class CollectionsCapQ2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Apartment apt = new Apartment();
		System.out.println("Enter how many apartments :");
		int n = sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++) {
			String str = sc.nextLine();
			String[] arr = str.split(":");
			apt.addDetails(arr[0], Integer.parseInt(arr[1]));
		}
		
		System.out.println("Enter min range :");
		int min = sc.nextInt();
		System.out.println("Enter max range :");
		int max = sc.nextInt();
		sc.nextLine();
		
		if(apt.totalRentInGivenRange(min, max) == 0) {
			System.out.println("no apartments found in this range");
		}else {
		System.out.println("total rent in range "+min + " to " + max +" is : "+apt.totalRentInGivenRange(min, max));
		}
	}
}
class Apartment{
	Map<String,Double> apartmentDetails = new HashMap<>();
	public void addDetails(String aptNo,double rent) {
		apartmentDetails.put(aptNo, rent);
	}
	public double totalRentInGivenRange(double min,double max) {
		double total = 0;
		for(Map.Entry<String, Double> res : apartmentDetails.entrySet()) {
			if(res.getValue() >= min && res.getValue() <= max) {
				total += res.getValue();			
			}
		}
			return total;
		
	}
}
