package com.capg.springboot.entity;

import java.util.List;

public class BookInfo {

	private int bookId;
	private String bname;
	private String author;
	private int rating;
	private List<String> reviews;
	
	public BookInfo() {
		
	}
	
	public BookInfo(int bookId, String bname, String author, int rating, List<String> reviews) {
		super();
		this.bookId = bookId;
		this.bname = bname;
		this.author = author;
		this.rating = rating;
		this.reviews = reviews;
	}
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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
