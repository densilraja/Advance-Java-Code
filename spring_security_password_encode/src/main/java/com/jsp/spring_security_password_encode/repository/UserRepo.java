package com.jsp.spring_security_password_encode.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.spring_security_password_encode.entity.Users;

public interface UserRepo extends JpaRepository<Users, Integer> {

	Optional<Users> findByName(String name);
}
