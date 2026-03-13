package com.capg.Springboot.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.Springboot.Entity.Books;
import com.capg.Springboot.Repository.BooksRepository;

@Service
public class BooksService {
	
	@Autowired
	BooksRepository booksRepository;
	
	public void addBook(Books book) {
		booksRepository.save(book);
	}
	
	public List<Books> getAllBooks(){
		List<Books> books = new ArrayList<>();
		booksRepository.findAll().forEach(b1 -> books.add(b1));
		
		System.out.println(books);
		
		return books;
	}

	public void update(Books books) {
		// TODO Auto-generated method stub
		booksRepository.save(books);
		
	}

	public void delete(int bookid) {
		// TODO Auto-generated method stub
		booksRepository.deleteById(bookid);
		
	}

	public Books getBookById(int bookid) {
		// TODO Auto-generated method stub
		return booksRepository.findById(bookid).get();
	}
	
	
}