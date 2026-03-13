package com.capg.Streams;
import java.util.*;
import java.util.stream.Collectors;

public class TerminationOperations {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Integer> list = new ArrayList<>();
		list.add(61);
		list.add(5);
		list.add(9);
		list.add(7);
		list.add(2);
		list.add(3);
		list.add(7);
		list.add(10);
		
		
		
		//collecting filtered data and storing in res list
		//List<Integer> res = list.stream().filter(a -> a >= 4).collect(Collectors.toList());
		//System.out.println(res);
		
		
		//counting the result data and storing them
		//int count =(int) list.stream().filter(a -> a >= 4).count();
		//System.out.println(count);
		
		
		//finding the first element after filtering or sorting
		//int a = (int) list.stream().sorted().findFirst().orElse(0);
		//System.out.println(a);
		
		
	}
}
