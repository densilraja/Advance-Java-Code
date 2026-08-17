package com.jsp.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.practice.entity.Practice;

public interface PracticeRepository extends JpaRepository<Practice, Integer>{

}
