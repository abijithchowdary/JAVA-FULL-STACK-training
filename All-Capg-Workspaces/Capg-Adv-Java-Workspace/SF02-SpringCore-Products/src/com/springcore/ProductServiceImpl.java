package com.springcore;

public class ProductServiceImpl implements ProductService{
	
	String product; //Step-8 MacAir12021 //Step-16 MacProM12021
	
	public ProductServiceImpl() {
		//Step 6
	}
	public ProductServiceImpl(String product) {
		this.product = product; //Step 7
	}
	
	//Setter Method.
	//Step 14
	public void setProduct(String product) {
		this.product = product; //Step 15
	}
	
	//Step-10 //Step-18
	public void allProducts() {
		System.out.println("Hello " + product);
	}
	
}