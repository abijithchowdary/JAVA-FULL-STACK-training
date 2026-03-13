package com.capg.Streams;
import java.util.*;
import java.util.stream.Collectors;

public class MInAndMax {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(5);
		list.add(9);
		list.add(6);
		list.add(2);
		list.add(3);
		list.add(7);
		list.add(10);
		
		//max element
		int max = list.stream().max((a,b) -> Integer.compare(a,b)).orElse(0);
		System.out.println(max);
		
		//min element
		int min = list.stream().min(Integer::compare).orElse(0);
		System.out.println(min);
	}
}
