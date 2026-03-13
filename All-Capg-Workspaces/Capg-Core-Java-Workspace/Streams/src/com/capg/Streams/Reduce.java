package com.capg.Streams;
import java.util.*;
import java.util.stream.Collectors;

public class Reduce {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		List<Integer> list = new ArrayList<>();
		list.add(6);
		list.add(5);
		list.add(9);
		list.add(7);
		list.add(2);
		list.add(3);
		list.add(7);
		list.add(10);
		
		int res = (int) list.stream().filter(a -> a >= 5).reduce(0, (b,c) -> b+c);
		System.out.println(res);
	}

}
