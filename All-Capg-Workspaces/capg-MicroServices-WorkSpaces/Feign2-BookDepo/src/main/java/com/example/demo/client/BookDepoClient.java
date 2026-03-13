package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.BookInfo;

@FeignClient(name="bookDepoClient", url="${bookInfo.service.url}")
public interface BookDepoClient {

    @GetMapping("/bookinfo/{bookId}")
    BookInfo getById(@PathVariable("bookId") String bookId);

}