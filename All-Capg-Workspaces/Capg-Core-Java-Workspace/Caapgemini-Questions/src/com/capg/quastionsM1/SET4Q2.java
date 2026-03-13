package com.capg.quastionsM1;

import java.util.*;

public class SET4Q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stocks s = new Stocks();
		int n = sc.nextInt();
		sc.nextLine();
		while(n-- > 0) {
			String str = sc.nextLine();
			switch(str) {
			case "ADD":s.addData(sc.nextLine(), sc.nextInt()); sc.nextLine();break;
			case "UPDATE":s.updateData(sc.nextLine(), sc.nextInt());sc.nextLine(); break;
			case "PRICES":System.out.println(s.getData(sc.nextLine())); break;
			case "TREND":System.out.println(s.trend(sc.nextLine())); break;
			case "HIGHEST PRICE":System.out.println(s.highestPrice(sc.nextLine())); break;
			}
		}
		
	}
}
class Stocks{
	Map<String,List<Integer>> stock = new HashMap<>();
	
    public void addData(String str,int price) {
		stock.putIfAbsent(str, new ArrayList<>());
		stock.get(str).add(price);
	}
    
	public void updateData(String str,int newPrice) {
		if(!stock.containsKey(str)) {
			System.out.println("No such stock exist");
			return;
		}
		stock.get(str).add(newPrice);
	}
	
	public String getData(String str) {
		if(stock.containsKey(str)) {
			return str + " Prices are : "+stock.get(str);
		}else {
			return "No stock exist";
		}
	}
	
	public String trend(String str) {
		List<Integer> prices = stock.get(str);
		int pri = prices.get(prices.size() - 2);
		int cur = prices.get(prices.size() - 1);
		if(pri < cur) {
			return "BULLISH";
		}else if(pri > cur){
			return "BEARISH";
		}else {
			return "STABLE MARKET";
		}
	}
	
	public int highestPrice(String str) {
		List<Integer> list = stock.get(str);
		return Collections.max(list);
	}
}
