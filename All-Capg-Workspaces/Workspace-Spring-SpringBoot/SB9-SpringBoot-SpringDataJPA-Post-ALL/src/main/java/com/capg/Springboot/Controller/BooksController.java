package com.capg.Springboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.Springboot.Entity.Books;
import com.capg.Springboot.Service.BooksService;


@RestController
public class BooksController {

	@Autowired
	BooksService booksService;
	
	@PostMapping("/addbook")
	public String addBook(@RequestBody Books book) {
		booksService.addBook(book);
		return "Book added successfully";
	}
	
	@GetMapping("/allbooks")
	public List<Books> getAllBook(){
		return booksService.getAllBooks();
	}
	
}
