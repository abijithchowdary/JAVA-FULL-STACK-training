package com.capg.Strings;
import java.util.*;


public class CapgQ1 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        System.out.println(processString(s,k));
        
        
    }
    public static String processString(String str,int k){
        //reverse
        str = new StringBuilder(str).reverse().toString();
        
        //changing vowels
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()){
            
            switch(c){
                case 'a': sb.append('e');break;
                case 'e': sb.append('i');break;
                case 'i': sb.append('o');break;
                case 'o': sb.append('u');break;
                case 'u': sb.append('a');break;
                default : sb.append(c);
            }
        }
        str = sb.toString();
        
        //remove duplicates
        StringBuilder sb1 = new StringBuilder();
        Set<Character> set = new LinkedHashSet<>();
        for(char c : str.toCharArray()){
            set.add(c);
        }
        for(char c : set){
            sb1.append(c);
        }
        str = sb1.toString();
        
        //rotations
        int n = str.length();
        
        k = k%n;
        str = str.substring(k)+str.substring(0,k);
        
        return str;
    }

}
