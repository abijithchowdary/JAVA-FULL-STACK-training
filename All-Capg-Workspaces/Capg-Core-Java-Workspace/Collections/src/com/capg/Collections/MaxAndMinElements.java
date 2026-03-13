package com.capg.Collections;
import java.util.*;

public class MaxAndMinElements {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		
		System.out.println("Enyter the elements in a list  : ");
		//Taking input from user
		while(sc.hasNext()) {
			list.add(sc.nextInt());
		}
		
		//Sorting
		Collections.sort(list);
		
		//Printing max and min by element index
		System.out.println("Max Element : "+list.get(0));
		System.out.println("Min element : "+list.get(list.size()-1));
		
		//printing by inbuild method
		System.out.println("Max Element : "+Collections.max(list));
		System.out.println("Min element : "+Collections.min(list));
	}
}
