package com.example.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BookInfo;

@RestController
@RequestMapping("/bookinfo")
public class BookInfoController {
	@GetMapping("/{bookId}")
	public BookInfo getById(@PathVariable("bookId") String bookId) {
        return new BookInfo(bookId, "Harry Potter","Jk ROwling", 65000.00);

	}
}
