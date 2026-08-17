package com.jsp.spring_security_password_encode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jsp.spring_security_password_encode.entity.Users;
import com.jsp.spring_security_password_encode.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public Users save(Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return repo.save(user);
	}
}
