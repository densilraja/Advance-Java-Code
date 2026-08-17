package com.jsp.spring_security_password_encode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.spring_security_password_encode.entity.Users;
import com.jsp.spring_security_password_encode.service.JwtService;
import com.jsp.spring_security_password_encode.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager manager;

    @GetMapping("/wel")
    public String welcome() {
        return "Welcome user";
    }

    @PostMapping("/save")
    public Users save(@RequestBody Users user) {
        return service.save(user);
    }

    @PostMapping("/verify")
    public String verify(@RequestBody Users user) {

        Authentication authentication = manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getName(),
                        user.getPassword()
                )
        );

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getName());
        }

        return "Invalid user request";
    }
}
