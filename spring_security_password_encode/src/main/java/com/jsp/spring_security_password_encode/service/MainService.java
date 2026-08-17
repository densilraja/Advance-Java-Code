package com.jsp.spring_security_password_encode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import com.jsp.spring_security_password_encode.entity.Users;
import com.jsp.spring_security_password_encode.repository.UserRepo;

@Service
public class MainService implements UserDetailsService {

	@Autowired
	private UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    Users user = repo.findByName(username)
	                     .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

	    return User.builder()
	               .username(user.getName())
	               .password(user.getPassword())
	               .roles(user.getRole())
	               .build();
	}

	
	
}
