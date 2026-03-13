package com.capg.Inputs;
import java.util.*;

public class HasNextMethod {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Integer> list = new ArrayList<>();
		while(sc.hasNext()) {
			list.add(sc.nextInt());
		}
		Collections.sort(list);
		System.out.println(list);
	}
}
