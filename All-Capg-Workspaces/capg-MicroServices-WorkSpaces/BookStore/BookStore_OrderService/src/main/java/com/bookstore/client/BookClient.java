package com.bookstore.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.bookstore.dto.BookDto;

@FeignClient(name = "book-service")
public interface BookClient {

    @GetMapping("/api/books/getbook/{id}")
    BookDto getBookById(@PathVariable("id") Long id);
}