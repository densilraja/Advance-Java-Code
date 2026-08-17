package com.jsp.practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.practice.entity.Practice;
import com.jsp.practice.repository.PracticeRepository;

@Service
public class PracticeService{
	
	@Autowired
	private PracticeRepository repo;
	
	// Add
	public Practice add(Practice p) {
		return repo.save(p);
	}
	
	// Add All
	public List<Practice> addAll(List<Practice> p){
		return repo.saveAll(p);
	}
	
	// Get All
	public List<Practice> getAll() {
		return repo.findAll();
	}
	
	// Get By Id
	public Practice getById(int id) {
		Optional<Practice> get = repo.findById(id);
		if(get.isPresent()) {
			return get.get();
		}
		return null;
	}
	
	// Update Entire Object
	public Practice update(Practice p) {
		return repo.save(p);
	}
	
	// Update Partially
	public Practice partialUpdate(Practice p, int id) {
		Optional<Practice> get = repo.findById(id);
		if(get.isPresent()) {
			Practice exist = get.get();
			exist.setName(p.getName());
			return repo.save(exist);
		}
		return null;
	}
	
	// Delete all
	public String deleteAll() {
		repo.deleteAll();
		return "Deleted Successfully";
	}
	
	// Delete By Id 
	public Practice deleteById(int id) {
		Optional<Practice> get = repo.findById(id);
		if(get.isPresent()) {
			repo.deleteById(id);
			return get.get();
		}
		return null;
	}

	
}
