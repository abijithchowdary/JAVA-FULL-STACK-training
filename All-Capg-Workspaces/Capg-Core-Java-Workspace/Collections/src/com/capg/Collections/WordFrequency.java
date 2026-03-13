package com.capg.Collections;
import java.util.*;

public class WordFrequency {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Sentence : ");
		String sentence = sc.nextLine();
		
		HashMap<String , Integer> map = new HashMap<>();		
		String[] words = sentence.split(" ");
		
		//counting the word repetitions 
		for(String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		
		System.out.println(map);
    }
}
