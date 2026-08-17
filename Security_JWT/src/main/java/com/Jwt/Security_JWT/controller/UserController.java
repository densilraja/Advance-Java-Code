package com.Jwt.Security_JWT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jwt.Security_JWT.entity.User;
import com.Jwt.Security_JWT.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    // Register User
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.saveUser(user);
    }

    // Login User
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return service.verify(user);
    }

}