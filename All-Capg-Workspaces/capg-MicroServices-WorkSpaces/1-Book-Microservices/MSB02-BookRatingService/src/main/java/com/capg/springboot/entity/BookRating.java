package com.capg.springboot.entity;

import java.util.List;

public class BookRating {
	
	private int bookId;
	private int rating;
	private List<String> reviews;
	
	public BookRating() {
		
	}
	
	public BookRating(int bookId, int rating, List<String> reviews) {
		super();
		this.bookId = bookId;
		this.rating = rating;
		this.reviews = reviews;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public List<String> getReviews() {
		return reviews;
	}
	public void setReviews(List<String> reviews) {
		this.reviews = reviews;
	}
	
}
