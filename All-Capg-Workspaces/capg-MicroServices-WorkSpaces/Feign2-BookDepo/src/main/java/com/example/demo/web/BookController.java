package com.example.demo.web;

import org.springframework.web.bind.annotation.*;

import com.example.demo.client.BookDepoClient;
import com.example.demo.model.BookInfo;

@RestController
@RequestMapping("/depo")
public class BookController {

    private final BookDepoClient bookDepoClient;

    public BookController(BookDepoClient bookDepoClient) {
        this.bookDepoClient = bookDepoClient;
    }

    // http://localhost:8080/depo/101

    @GetMapping("/{bookId}")
    public BookDepoResponse getBookFromDepo(@PathVariable String bookId) {

        BookInfo book = bookDepoClient.getById(bookId);

        return new BookDepoResponse(
                "D001",
                "Kolkata Book Depot",
                book
        );
    }

    public static class BookDepoResponse {

        private String depoId;
        private String depoAddress;
        private BookInfo bookInfo;

        public BookDepoResponse(String depoId, String depoAddress, BookInfo bookInfo) {
            this.depoId = depoId;
            this.depoAddress = depoAddress;
            this.bookInfo = bookInfo;
        }

        public String getDepoId() { return depoId; }
        public void setDepoId(String depoId) { this.depoId = depoId; }

        public String getDepoAddress() { return depoAddress; }
        public void setDepoAddress(String depoAddress) { this.depoAddress = depoAddress; }

        public BookInfo getBookInfo() { return bookInfo; }
        public void setBookInfo(BookInfo bookInfo) { this.bookInfo = bookInfo; }
    }
}