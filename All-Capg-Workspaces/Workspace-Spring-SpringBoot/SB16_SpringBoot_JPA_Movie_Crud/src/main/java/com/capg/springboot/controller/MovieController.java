package com.capg.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.springboot.entity.Movie;
import com.capg.springboot.exception.MovieNotFoundException;
import com.capg.springboot.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@PostMapping("/add")
	public int addMovie(@RequestBody Movie movie) {
		return service.addMovie(movie);
	}
	
	@PutMapping("/update/{id}")
	public Movie updateMovie(@PathVariable int id,@RequestBody Movie movie) {
		
		return service.updateMovie(id, movie);
	}
	
	@GetMapping("/getmovie/{id}")
	public ResponseEntity<?> getMovie(@PathVariable int id) {
		
		Movie m = service.getMovieById(id);
		
		if(m == null) {
			throw new MovieNotFoundException("Movie Id Not Found!!");
		}
		
		return new ResponseEntity<>(m,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteMovie(@PathVariable int id) {
		service.deleteMovie(id);
		return "Movie Deleted Successfully";
	}
	
	@GetMapping("/getallmovies")
	public List<Movie> getAllMovies(){
		return service.getAllMovie();
	}
}
