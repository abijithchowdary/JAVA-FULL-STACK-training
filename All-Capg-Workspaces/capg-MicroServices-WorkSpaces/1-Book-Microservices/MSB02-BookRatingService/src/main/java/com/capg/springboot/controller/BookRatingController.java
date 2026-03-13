package com.capg.springboot.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.springboot.entity.BookRating;

@RestController
@RequestMapping("/ratings")
public class BookRatingController {

	@GetMapping("/bookrating")
	public BookRating getRating() {
		return new BookRating(101,5,Arrays.asList("Extraordinary","Amazing","Very Helpful!"));
	}
}
