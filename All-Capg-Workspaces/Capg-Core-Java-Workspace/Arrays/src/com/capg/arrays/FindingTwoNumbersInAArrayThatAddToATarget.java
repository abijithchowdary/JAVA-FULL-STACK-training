package com.capg.arrays;
import java.util.Scanner;

public class FindingTwoNumbersInAArrayThatAddToATarget {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of array elements : ");
		int a[] = new int[sc.nextInt()];
		
		System.out.println("Enter the array elements : ");
		//taking input
		for(int i=0;i<a.length;i++) {
			a[i] = sc.nextInt();
		}
		
		System.out.println("Enter the target value : ");
		//taking input of target number
		int tn = sc.nextInt();
		
		boolean found = false;
		
		//finding the numbers
		for(int i=0;i<a.length;i++) {
			for(int j = i+1;j<a.length;j++) {
				if(a[i] + a[j] == tn) {
					System.out.println("The numbers are :" + a[i] + ", " + a[j]);
					found = true;
				}
			}
		}
		if(!found) {
			System.out.println("No Such pair has found!!!!!");
		}
		
	}
}
