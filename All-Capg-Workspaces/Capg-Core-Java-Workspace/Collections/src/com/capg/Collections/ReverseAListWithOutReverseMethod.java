package com.capg.Collections;
import java.util.*;

public class ReverseAListWithOutReverseMethod {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		List<Integer> list = new ArrayList<>();
		
		System.out.println("Enter the no of elements in the list : ");
		int n = sc.nextInt();
		System.out.println("Enter the elements in the list : ");
		for(int i=0;i<n;i++){
			list.add(sc.nextInt());
		}
		
		//before reversing
		System.out.println(list);
		//printing
		for(int i=n-1;i>=0;i--) {
			System.out.println(list.get(i));
		}
	}

}
