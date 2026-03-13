package com.capg.springboot.repository;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.capg.springboot.entity.Movie;
import com.capg.springboot.exception.MovieNotFoundException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class MovieDaoImpl implements MovieDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public int saveMovie(Movie movie) {
		
		em.persist(movie);
		
		return movie.getMovieId();
	}

	@Override
	public Movie updateMovie(int id,Movie movie) {
		
		Movie m = em.find(Movie.class,id);
		
		m.setMname(movie.getMname());
		
		m.setGenre(movie.getGenre());
		
		m.setRating(movie.getRating());
		
		em.flush();
		
		return m;
	}

	@Override
	public void deleteMovie(int id) {
		
		Movie movie = em.find(Movie.class,id);
		em.remove(movie);
	}

	@Override
	public Movie getMovieByID(int id) {
		Movie m = em.find(Movie.class,id);
		return m;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> getAllMovies() {
		
		Query q = em.createQuery("select m from Movie m");
		
		return q.getResultList();
	}

}
