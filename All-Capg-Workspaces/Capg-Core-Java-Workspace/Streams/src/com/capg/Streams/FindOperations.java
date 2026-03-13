package com.capg.Streams;
import java.util.*;
import java.util.stream.Collectors;

public class FindOperations {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		List<Integer> list = new ArrayList<>();
		list.add(61);
		list.add(5);
		list.add(9);
		list.add(7);
		list.add(2);
		list.add(3);
		list.add(7);
		list.add(10);
		
		//anyMatch returns true if at least one elements satisfies condition
		boolean a = list.stream().anyMatch(x -> x > 8);
		//allMatch returns true if all elements satisfies condition
		boolean b = list.stream().allMatch(y -> y > 8);
		//noneMatch returns true if at no elements satisfies condition
		boolean c = list.stream().noneMatch(z -> z > 8);
		
		System.out.println(a+" "+b+" "+c);
	}
}
