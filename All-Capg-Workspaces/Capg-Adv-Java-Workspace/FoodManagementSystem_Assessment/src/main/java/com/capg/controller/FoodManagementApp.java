package com.capg.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capg.model.Category;
import com.capg.model.FoodItem;
import com.capg.service.CategoryService;
import com.capg.service.FoodService;
import com.capg.service.OrderService;

public class FoodManagementApp {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring.xml");
		
		Scanner sc = new Scanner(System.in);
		
		CategoryService cs = ctx.getBean(CategoryService.class);
		
		FoodService fs = ctx.getBean(FoodService.class);
		
		OrderService os = ctx.getBean(OrderService.class);
		
		System.out.println("Welcome to Food Management System!");
		
		boolean flag = true;
		
		while(flag) {
			
			System.out.println("Choose below option!");
			
			System.out.println("1. Add Category!");
			
			System.out.println("2. Add Food Item!");
			
			System.out.println("3. Remove Food Item!");
			
			System.out.println("4. Get Items By Category!");
			
			System.out.println("5. Place your Order!");
			
			System.out.println("6. Your Total Order Amount!");
			
			System.out.println("7. Exit Application!");
			
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			
			sc.nextLine();
			
			switch(choice) {
			
				case 1:
					
					System.out.print("Enter Category Name: ");
					
					String name = sc.nextLine();
					
					System.out.println("Enter Discription: ");
					
					String des = sc.nextLine();
					
					cs.addCategory(name, des);
					
					System.out.println("\nCategory Added Successfully!\n");
					
					break;
					
				case 2:
					
					System.out.println("\nHere is the Category List to add the food items under!\n");
					
					List<Category> list = cs.getAllCategories();
					
					for(Category cate : list) {
						System.out.println(cate.toString());
					}
					
					System.out.print("Enter the Category Id: ");
					
					long cid = sc.nextLong();
					
					sc.nextLine();
					
					System.out.print("Enter Food Name: ");
					
					String fname = sc.nextLine();
					
					System.out.println("Enter price: ");
					
					double price = sc.nextDouble();
					
					fs.addFoodItem(cid, fname, price);
					
					break;
					
				case 3:
					
					System.out.println("Enter the Food Item Id To Remove: ");
					
					long foodId = sc.nextLong();
					
					fs.removeFoodItem(foodId);
					
					break;
					
				case 4:
					
					System.out.println("\nHere is the Category List to get food items!\n");
					
					List<Category> l = cs.getAllCategories();
					
					for(Category cate : l) {
						System.out.println(cate.toString());
					}
					
					System.out.print("\nEnter the category_id: ");
					
					long id = sc.nextLong();
					
					List<FoodItem> lis = fs.getItemsByCategory(id);
					
					System.out.println("\n Here Are The Food Items On Mentioned Category!!");
					
					for(FoodItem item : lis) {
						System.out.println(item);
					}
					
					break;
					
				case 5:
					
					List<Long> ids = new ArrayList<>();
					
					System.out.print("Enter your name: ");
					
					String customername = sc.nextLine();
					
					System.out.print("Enter the no of items to order: ");
					
					int num = sc.nextInt();
					
					System.out.print("Enter the Food Item id's: ");
					
					for(int i=0;i<num;i++) {
						ids.add(sc.nextLong());
					}
					
					os.placeOrder(ids, customername);
					
					break;
					
				case 6:
					
					System.out.print("Enter your orderid for bill amount: ");
					
					long orderId = sc.nextLong();
					
					double bill = os.calculateTotal(orderId);
					
					System.out.println("Your Total Bill: " + bill);
					
				case 7:
					
					System.out.println("\nExiting....!\n");
					flag = false;
					
					break;
					
				default:
					
					System.out.println("Please choice correct option!");
			}
		}
	}
}
