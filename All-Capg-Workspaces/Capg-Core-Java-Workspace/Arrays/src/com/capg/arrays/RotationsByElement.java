package com.capg.arrays;
import java.util.*;

public class RotationsByElement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of elements : ");
		int[] a = new int[sc.nextInt()];
		
		System.out.println("Enter the elements : ");
		for(int i=0;i<a.length;i++) {
			a[i] = sc.nextInt();
		}
		
		System.out.println("Enter the target number: ");
		int tn = sc.nextInt();

		for(int i=0;i<a.length;i+=tn) {
			int start = i;
			int end = Math.min(i+tn-1, a.length-1);
			reverse(a,start,end);
		}
		
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
}
	public static void reverse(int[] a,int start,int end) {
		int temp = a[start];
		a[start] = a[end];
		a[end] = temp;
	}
}