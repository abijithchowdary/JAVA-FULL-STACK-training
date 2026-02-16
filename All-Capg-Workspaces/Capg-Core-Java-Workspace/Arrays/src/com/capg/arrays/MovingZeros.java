package com.capg.arrays;
import java.util.Scanner;

public class MovingZeros {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of array elements : ");
		int a[] = new int[sc.nextInt()];
		
		System.out.println("Enter the array elements : ");
		//taking input
		for(int i=0;i<a.length;i++) {
			a[i] = sc.nextInt();
		}
		
		int nonZeroIndex = 0;
		for(int i=0;i<a.length;i++) {
			if(a[i] != 0) {
				int temp = a[i];
				a[i] = a[nonZeroIndex];
				a[nonZeroIndex] = temp;
				nonZeroIndex++;
			}
		}
		
		//printing
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i] + " ");
		}
		
	}

}
