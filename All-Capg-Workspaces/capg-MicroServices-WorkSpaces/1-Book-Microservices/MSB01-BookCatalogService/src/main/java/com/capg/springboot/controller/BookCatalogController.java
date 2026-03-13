package com.capg.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.springboot.entity.Book;

@RestController
@RequestMapping("/book")
public class BookCatalogController {
	
	@GetMapping("/details")
	public Book getBookDetails() {
		return new Book(101,"Hibernate Fundamentals","Gavin King The King!");
	}
}
