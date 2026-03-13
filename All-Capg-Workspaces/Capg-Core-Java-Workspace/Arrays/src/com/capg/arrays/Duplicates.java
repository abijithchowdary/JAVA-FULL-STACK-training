package com.capg.arrays;
import java.util.*;

public class Duplicates {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 
		System.out.println("Enter number of elements : ");
		int[] a = new int[sc.nextInt()];
		
		//taking array input by loop
		System.out.println("Enter the elements : ");
		for(int i=0;i<a.length;i++) {
			a[i] = sc.nextInt();
		}
		
		//sorting
		for(int i=0;i<a.length-1;i++) {
			for(int j=0;j<a.length;j++) {
				if(a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		
		//finding duplicates
		for(int i=0;i<a.length-1;i++) {
			if(a[i] == a[i+1]) {
				System.out.println("Duplicate : "+a[i]);
				while(i < a.length-1 && a[i] == a[i+1]) {
					i++;
				}
			}
		}
	}
}
