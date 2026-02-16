package com.corejava.layers;

import java.util.List;
import java.util.Scanner;

public class ProductController {

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the cart!");
		
		ProductService ps = new ProductService();
		
		boolean flag = true;
		
		while(flag) {
			
			System.out.println("Choose below!");
			
			System.out.println("1. Display Products!");
			System.out.println("2. Add Product!");
			System.out.println("3. Delete Product!");
			System.out.println("4. Exit!");
			
			System.out.println("Enter you choice: ");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			
				case 1: 
					
					List<ProductBean> list = ps.displayProducts();
					
				    for(ProductBean pb : list) {
				    	System.out.println(pb);
				    }
				    
					break;
					
				case 2:
					
					System.out.print("Enter sno: ");
					int sno = sc.nextInt();
					System.out.println("Enter Product Name: ");
					String pname = sc.next();
					System.out.println("Enter Product Price: ");
					double price = sc.nextDouble();
					
					int x = ps.addProduct(sno,pname,price);
					
					if(x != 0) {
						System.out.println("Product Added Successfully!");
					}
					else {
						System.out.println("Failed Adding Product!");
					}
					
					break;
					
				case 3:
					
					System.out.println("Enter Sno To Delete Product: ");
					
					int sno1 = sc.nextInt();
					
					int y = ps.deleteProduct(sno1);
					
					if(y != 0) {
						System.out.println("Product Deleted Successfully!");
					}
					else {
						System.out.println("Failed Deleting Product!");
					}
					
					break;
					
				case 4:
					
					System.out.println("Exiting..!");
					flag = false;
					break;
					
				default:
					System.out.println("Enter the valid option!");
				}
		}
	}

}
