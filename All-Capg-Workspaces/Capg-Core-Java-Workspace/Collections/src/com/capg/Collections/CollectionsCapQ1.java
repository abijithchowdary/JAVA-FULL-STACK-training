package com.capg.Collections;
import java.util.*;

public class CollectionsCapQ1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		CakeOrder co = new CakeOrder();
		System.out.println("Enter how many cake orders :");
		int n = sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++) {
			String str = sc.nextLine();
			String[] arr = str.split(":");
			co.addOrderDetails(arr[0], Integer.parseInt(arr[1]));
		}
		
		System.out.println("Enter Search cost :");
		int searchElement = sc.nextInt();
		sc.nextLine();
		
		Map<String, Double> res = co.findAboveOrdesAboveCost(searchElement);
		
		if(res.isEmpty()) {
			System.out.println("No orders above the Search Cost");
		}else {
			for(Map.Entry<String,Double> e : res.entrySet()) {
				System.out.println("Order Id : " + e.getKey() + ", CakeCost : "+e.getValue());
			}
		}
		
		
	}
}
class CakeOrder{
	private Map<String, Double> map = new HashMap<>();
	
	public void addOrderDetails(String OrderId,double cakeCost) {
		map.put(OrderId, cakeCost);
	}
	public Map<String, Double> findAboveOrdesAboveCost(double cakeCost){
		Map<String,Double> result = new HashMap<>();
		
		for(Map.Entry<String, Double> entry : map.entrySet()) {
			if(entry.getValue() > cakeCost) {
				result.put(entry.getKey(), entry.getValue());
			}
		}
		return result;
	}
}