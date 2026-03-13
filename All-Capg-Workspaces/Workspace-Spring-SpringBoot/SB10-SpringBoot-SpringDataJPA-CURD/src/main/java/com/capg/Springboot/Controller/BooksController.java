package com.capg.Springboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	//Book search by Id
	
	@GetMapping("/bookid/{bookid}")
	public Books getBookById(@PathVariable("bookid") int bookid) {
		return booksService.getBookById(bookid);
	}
	
	//update (PUT)
	
	@PutMapping("/updatebook")
	public Books update(@RequestBody Books books) {
		booksService.update(books);
		return books;
	}
	
	@DeleteMapping("/bookid/{bookid}")
	public void deleteBook(@PathVariable("bookid") int bookid) {
		booksService.delete(bookid);
	}
	
}