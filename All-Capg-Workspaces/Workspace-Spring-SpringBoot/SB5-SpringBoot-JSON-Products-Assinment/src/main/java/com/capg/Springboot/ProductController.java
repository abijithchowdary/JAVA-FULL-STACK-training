package com.capg.Springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	ProductService ps;
	
	@RequestMapping("login.spring")
	public String validLogin() {
		return "Welcome to our page";
	}
	
	@RequestMapping("allproducts")
	public List<ProductBean> getAllProducts(){
		return ps.getProducts();
	}
}
