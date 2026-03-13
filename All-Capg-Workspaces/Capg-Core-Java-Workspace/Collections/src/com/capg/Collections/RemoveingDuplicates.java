package com.capg.Collections;
import java.util.*;

public class RemoveingDuplicates {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		
		System.out.println("Enter the no of elements in the list : ");
		int n = sc.nextInt();
		System.out.println("Enter the elements in the list : ");
		for(int i=0;i<n;i++){
			list.add(sc.nextInt());
		}
		
		//printing before
		System.out.println(list);
		
		//removing duplicates
		HashSet<Integer> set = new HashSet<>(list);
		
		//getting it back into arraylist
		List<Integer> newList = new ArrayList<>(set);
		
		//printing after removing duplicates
		System.out.println(newList);
	}
}
