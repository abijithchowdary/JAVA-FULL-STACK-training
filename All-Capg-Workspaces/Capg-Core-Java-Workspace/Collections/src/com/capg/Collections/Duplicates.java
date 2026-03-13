package com.capg.Collections;
import java.util.*;

public class Duplicates {
	public static void main(String[] ars) {
		List<Integer> list = Arrays.asList(1,2,2,3,4,5,2,6,5,7,8,9,9,8,7,5,4,3,2,3);
		
		Set<Integer> seen = new HashSet<>();
		List<Integer> dpl = new ArrayList<>();
		for(int i : list) {
			if(!seen.add(i)) {
				dpl.add(i);
			}
		}
		System.out.print(list);
		System.out.print("\n"+seen);
		System.out.print("\n"+dpl);
	}
}
