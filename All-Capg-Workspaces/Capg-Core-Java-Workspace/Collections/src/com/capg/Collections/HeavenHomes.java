package com.java.m1;


import java.util.*;
import java.util.stream.*;

public class HeavenHomes {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		Apartment a = new Apartment();
		
		int n = sc.nextInt();
		sc.nextLine();
		
		while(n-- > 0) {
			String details[] = sc.nextLine().split(":");
			
			a.addApartmentDetails(details[0], Double.parseDouble(details[1]));
			
			
		}
		
		double p = a.findTotalRentOfApartmentsInTheGivenRange(sc.nextDouble(), sc.nextDouble());
		System.out.println(p);
		
		
	}
}

class Apartment{
	private Map<String, Double> apartmentDetailsMap = new HashMap<>();
	
	public void addApartmentDetails(String apNo,double rent) {
		apartmentDetailsMap.put(apNo,rent);
	}
	
	public double findTotalRentOfApartmentsInTheGivenRange(double minR,double maxR) {
		return apartmentDetailsMap.entrySet().stream()
						.filter(obj -> obj.getValue()>=minR && obj.getValue()<=maxR)
						.mapToDouble(obj ->(obj.getValue()))
						.sum();
	}
}