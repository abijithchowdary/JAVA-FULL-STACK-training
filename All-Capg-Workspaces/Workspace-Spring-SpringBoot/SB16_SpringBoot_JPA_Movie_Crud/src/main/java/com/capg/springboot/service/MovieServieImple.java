package com.capg.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capg.springboot.entity.Movie;
import com.capg.springboot.repository.MovieDao;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MovieServieImple implements MovieService{
	
	@Autowired
	private MovieDao dao;

	@Override
	public int addMovie(Movie movie) {
		return dao.saveMovie(movie);
	}

	@Override
	public Movie updateMovie(int id,Movie movie) {
		return dao.updateMovie(id, movie);
	}

	@Override
	public Movie getMovieById(int id) {
	
		return dao.getMovieByID(id);
	}

	@Override
	public void deleteMovie(int id) {
	
		dao.deleteMovie(id);
	}

	@Override
	public List<Movie> getAllMovie() {
		return dao.getAllMovies();
	}

}
