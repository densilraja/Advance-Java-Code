package com.jsp.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/wel")
    public String welcom(){
        return "Welcome to Security";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Welcome Admin";
    }

    @GetMapping("/user")
    public String user(){
        return "Welcome User";
    }
}
