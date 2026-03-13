package com.capg.springboot.repository;

import java.util.List;

import com.capg.springboot.entity.Movie;

public interface MovieDao {
	
	public int saveMovie(Movie movie);
	
	public Movie updateMovie(int id,Movie movie);
	
	public void deleteMovie(int id);
	
	public Movie getMovieByID(int id);
	
	public List<Movie> getAllMovies();
}
