package com.capg.arrays;
import java.util.Scanner;

public class MaxElement {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
int[] a = new int[10];
		
		System.out.println("Enter the array elements : ");
		
		//loop to take input
		for(int i=0;i<a.length;i++) {
			a[i] = sc.nextInt();
		}
		
		//Sorting
		for(int i=0;i<a.length-1;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		
		//printing max Element
		System.out.println("max element in a array is : "+a[a.length-1]);
	}
}
