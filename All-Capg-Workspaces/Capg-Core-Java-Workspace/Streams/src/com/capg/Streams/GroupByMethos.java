package com.capg.Streams;
import java.util.*;
import java.util.stream.Collectors;

public class GroupByMethos {
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
		
		//groupBy
		Map<Boolean,List<Integer>> res = (Map<Boolean, List<Integer>>) list.stream().collect(Collectors.groupingBy(a -> a >= 4));
		System.out.println(res);
	}
}
