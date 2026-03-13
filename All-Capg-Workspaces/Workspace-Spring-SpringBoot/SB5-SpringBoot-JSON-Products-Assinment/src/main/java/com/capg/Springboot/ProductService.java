package com.capg.Springboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	private List products = Arrays.asList(new ProductBean(1,"Washing Machine",35000),new ProductBean(2,"TV",18000));
	
	
	public List<ProductBean> getProducts(){
		return products;
	}
	
}
