package com.capg.springboot.service;

import java.util.List;

import com.capg.springboot.entity.Movie;

public interface MovieService {
	
	public int addMovie(Movie movie);
	
	public Movie updateMovie(int id,Movie movie);
	
	public Movie getMovieById(int id);
	
	public void deleteMovie(int id);
	
	public List<Movie> getAllMovie();
}
