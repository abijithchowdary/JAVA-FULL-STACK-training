package com.capg.arrays;
import java.util.Scanner;

public class InsertionSorting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[10];
		
		System.out.println("Enter the array elements : ");
		
		//loop to take input
		for(int i=0;i<a.length;i++) {
			a[i] = sc.nextInt();
		}
		
		//Sorting
		for(int i=1;i<a.length;i++) {
			int key = a[i];
			int j = i-1;
			while(j >= 0 && a[j] > key) {
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = key;
		}
		
		//printing
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}
}
