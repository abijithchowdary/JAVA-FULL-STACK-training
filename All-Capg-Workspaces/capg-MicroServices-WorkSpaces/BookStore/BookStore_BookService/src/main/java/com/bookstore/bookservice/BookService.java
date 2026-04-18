package com.bookstore.bookservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookentity.Book;
import com.bookstore.bookrepository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	public Book getBookById(long id) {
		return bookRepository.findById(id).orElse(null);
	}
	
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Book updateBook(long id, Book bookDetails) {
		Book book = bookRepository.findById(id).orElse(null);
		if (book != null) {
			book.setTitle(bookDetails.getTitle());
			book.setAuthor(bookDetails.getAuthor());
			book.setIsbn(bookDetails.getIsbn());
			book.setPrice(bookDetails.getPrice());
			book.setQuantity(bookDetails.getQuantity());
			book.setCategory(bookDetails.getCategory());
			return bookRepository.save(book);
		}
		return null;
	}
	
	public void deleteBook(long id) {
		bookRepository.deleteById(id);
		System.out.println("Book with ID " + id + " has been deleted.");
	}
}
