package com.capg.arrays;
import java.util.Scanner;

public class ReverseArrayWithoutSecondArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements in an arrray : ");
		int[] a = new int[sc.nextInt()];
		int n = a.length;
		
		//taking input
		for(int i = 0; i<n;i++) {
			a[i] = sc.nextInt();
		}
		
		//array before reversing
		for(int i = 0; i<n;i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();  //for going to next line
		
		//reversing the array 
		for(int i = 0; i<n/2;i++) {
			int temp = a[i];
			a[i] = a[n-1-i];
			a[n-1-i] = temp;
		}
		
		//printing the reversed array
		for(int i = 0; i<n;i++) {
			System.out.print(a[i] + " ");
		}
	}
}
