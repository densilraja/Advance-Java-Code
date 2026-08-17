package com.Jwt.Security_JWT.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Jwt.Security_JWT.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

}