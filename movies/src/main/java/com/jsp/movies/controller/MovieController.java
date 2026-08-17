package com.jsp.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.movies.Utils.OtpUtil;
import com.jsp.movies.Utils.ResponseStructure;
import com.jsp.movies.entity.Movie;
import com.jsp.movies.service.EmailVerificataion;
import com.jsp.movies.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService service;
	@Autowired
	private OtpUtil otpUtil;
	@Autowired
	private EmailVerificataion verificataion;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Movie>> save(@RequestBody Movie movie) {
		ResponseStructure<Movie> rs = new ResponseStructure<>();
		rs.setStatus(HttpStatus.CREATED.value());
		rs.setMessage("Movie Saved Successfully");
		rs.setData(movie);
		return new ResponseEntity<>(rs, HttpStatus.CREATED);
	}

	@PostMapping("/saveall")
	public List<Movie> saveAll(@RequestBody List<Movie> movie) {
		return service.insertAll(movie);
	}

	@GetMapping("/byid/{id}")
	public Movie getById(@PathVariable int id) {
		return service.fetchById(id);
	}

	@GetMapping("/getall")
	public List<Movie> getAll() {
		return service.fetchAll();
	}

	@PutMapping("/update")
	public Movie updateMovie(@RequestBody Movie movie) {
		return service.update(movie);
	}

	@PatchMapping("/patchupdate/{id}")
	public Movie patchUpdate(@PathVariable int id, @RequestBody Movie movie) {
		return service.patchUpdate(id, movie);
	}

	@DeleteMapping("/delete")
	public String deleteAll() {
		service.deleteAll();
		return "All Movie deleted successfully";
	}

	@DeleteMapping("deletebyid/{id}")
	public String deleteById(@PathVariable int id) {
		service.deleteById(id);
		return "Movie Deleted Successfully";

	}

	@GetMapping("/findbyname/{name}")
	public Movie findByName(@PathVariable String name) {
		return service.findByName(name);
	}

	@GetMapping("/findbydirector/{director}")
	public List<Movie> findByDirector(@PathVariable String director) {
		return service.findByDirector(director);
	}
	
	@GetMapping("/yearless/{year}")
	public List<Movie> findByYear(@PathVariable int year){
		return service.findByYearLessThan(year);
	}
	
	@PostMapping("/verify/{email}")
	public String verify(@PathVariable String email) {
		String otp = otpUtil.generateOtp();
		verificataion.verifyEmail(email, otp);
		return "Otp Send Successfully";
	}
}
