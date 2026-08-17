package com.jsp.movies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.movies.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

	public Movie findByName(String name);

	public List<Movie> findByDirector(String director);

	public List<Movie> findByHero(String hero);

	@Query
	public List<Movie> findByHeroin(String heroin);
	
	@Query("select m from Movie m where m.year < :year")
	public List<Movie> findByYearLessThan(@Param("year") int year);

}
