package com.jsp.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.practice.entity.Practice;
import com.jsp.practice.service.PracticeService;


@RestController
public class PracticeController {
	@Autowired
	private PracticeService service;
	
	@PostMapping("/add")
	public Practice add(@RequestBody Practice p) {
		return service.add(p);
	}
	
	@PostMapping("/saveall")
	public List<Practice> addAll(@RequestBody List<Practice> p){
		return service.addAll(p);
	}
	
	@GetMapping("/getall")
	public List<Practice> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/get/{id}")
	public Practice getById(@PathVariable int id) {
		return service.getById(id);
	}
	
	
	@PutMapping("/put")
	public Practice put(Practice p) {
		return service.update(p);
	}
	
	@PatchMapping("/patch/{id}")
	public Practice patch(Practice p, @PathVariable int id) {
		return service.partialUpdate(p, id);
	}
	
	@DeleteMapping("/delete")
	public String delete() {
		return service.deleteAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public Practice deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
}
