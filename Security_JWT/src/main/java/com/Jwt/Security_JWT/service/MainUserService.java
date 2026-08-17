package com.Jwt.Security_JWT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Jwt.Security_JWT.entity.User;
import com.Jwt.Security_JWT.repo.UserRepo;

@Service
public class MainUserService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User u = repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User name not found"));

        return org.springframework.security.core.userdetails.User.builder()
                .username(u.getUsername())
                .password(u.getPassword())
                .roles(u.getRole())
                .build();
    }

}