package com.capg.arrays;

import java.util.Scanner;

public class SelectionSorting {
	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		int[] a = new int[10];
		
		System.out.println("Enter the array elements : ");
		
		//loop to take input
		for(int i=0;i<a.length;i++) {
			a[i] = sc.nextInt();
		}
		
		//Sorting
		for(int i=0;i<a.length-1;i++) {
			int minIndex = i;
			for(int j=i+1;j<a.length;j++) {
				if(a[j] < a[minIndex]) {
					minIndex = j;
				}}
				int temp = a[minIndex];
				a[minIndex] = a[i];
				a[i] = temp;
				
			}
		
		//printing
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}
}
