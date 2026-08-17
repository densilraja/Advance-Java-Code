package com.jsp.library_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.library_management.entity.Books;

public interface BookRepo extends JpaRepository<Books, Integer> {
	Books findByPrice(double price);
}
