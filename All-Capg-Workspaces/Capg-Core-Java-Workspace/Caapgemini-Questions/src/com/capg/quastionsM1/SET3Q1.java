package com.capg.quastionsM1;
import java.util.*;

public class SET3Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		if(validateString(sc.nextLine())) {
			System.out.println("VALID");
		}else {
			System.out.println("INVALID");
		}
	}
	public static boolean validateString(String str) {
		String regex = "^[a-z]{4,}\\.[a-z]{4,}\\d{4}@(hr|sales|manager|developer)\\.company\\.com$";
		if(str.matches(regex)) {
			return true;
		}else {
			return false;
		}
	}
}
