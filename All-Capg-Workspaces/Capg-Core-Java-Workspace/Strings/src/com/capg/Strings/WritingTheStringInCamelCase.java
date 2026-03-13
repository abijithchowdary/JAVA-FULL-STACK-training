package com.capg.Strings;
import java.util.*;

public class WritingTheStringInCamelCase {
	public static void main(String[] args) {
		String s = "Am Billa Abijith Chowdary";
		StringBuilder h = new StringBuilder("#");
		
		//spliting
		String[] str = s.split(" ");
		
		//making first letter capital
		for(String word : str) {
			if(word.length() > 0) {
				String fl = word.substring(0,1).toUpperCase();
				String rl = word.substring(1).toLowerCase();
				h.append(fl).append(rl);
			}
		}
		System.out.println(h.toString());
	}
}
