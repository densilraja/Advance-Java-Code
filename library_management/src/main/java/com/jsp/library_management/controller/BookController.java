package com.jsp.library_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.library_management.entity.Books;
import com.jsp.library_management.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService service;
	
	@PostMapping("/save")
	public Books save(@RequestBody Books book) {
		service.insert(book);
		return book;
	}
	
	@PostMapping("/saveall")
	public List<Books> saveAll(@RequestBody List<Books> book){
		service.insertAll(book);
		return book;
	}
	
	@GetMapping("/findall")
	public List<Books> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/find/{id}")
	public Books findById(@PathVariable int id) {
		return service.find(id);
	}
	
	@GetMapping("/findbyprice/{price}")
	public Books findByBookPrice(@PathVariable double price) {
	    return service.findByPrice(price);
	}
}
