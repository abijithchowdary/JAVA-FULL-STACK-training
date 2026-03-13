package com.capg.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capg.springboot.entity.Book;
import com.capg.springboot.entity.BookInfo;
import com.capg.springboot.entity.BookRating;

@RestController
@RequestMapping("/info")
public class BookInfoController {
	
	@Autowired
	private RestTemplate rest;
	
	@GetMapping("/book")
	public BookInfo getBookInfo() {
		
		Book book = rest.getForObject("http://localhost:9091/book/details", Book.class);
		BookRating brate = rest.getForObject("http://localhost:9092/ratings/bookrating", BookRating.class);
		
		BookInfo info = new BookInfo(book.getBid(),book.getBname(),book.getAuthor(),brate.getRating(),brate.getReviews());
		
		return info;
	}
}
