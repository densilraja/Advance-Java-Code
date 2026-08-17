package com.jsp.movies.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.movies.entity.Movie;
import com.jsp.movies.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repo;

	public Movie insert(Movie movie) {
		return repo.save(movie);
	}

	public List<Movie> insertAll(List<Movie> movie) {
		return repo.saveAll(movie);
	}

	public Movie fetchById(int id) {
		Optional<Movie> byId = repo.findById(id);
		if (byId.isPresent()) {
			return byId.get();
		}
		return null;
	}

	public List<Movie> fetchAll() {
		return repo.findAll();
	}

	public Movie update(Movie movie) {
		return repo.save(movie);
	}

	public Movie patchUpdate(int id, Movie updated) {
		Optional<Movie> byId = repo.findById(id);
		if (byId.isPresent()) {
			Movie exist = byId.get();
			exist.setName(updated.getName());
			exist.setDirector(updated.getDirector());
			return repo.save(exist);
		}
		return repo.save(updated);
	}

	public void deleteAll() {
		repo.deleteAll();
	}

	public void deleteById(int id) {
		repo.deleteById(id);
	}

	public Movie findByName(String name) {
		return repo.findByName(name);
	}

	public List<Movie> findByDirector(String director) {
		return repo.findByDirector(director);
	}
	
	public List<Movie> findByYearLessThan(int year){
		return repo.findByYearLessThan(year);
	}
}
