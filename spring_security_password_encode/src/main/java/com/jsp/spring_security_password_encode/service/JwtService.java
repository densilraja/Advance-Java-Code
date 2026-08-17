package com.jsp.spring_security_password_encode.service;

import org.springframework.stereotype.Service;

@Service
public class JwtService {

    public String generateToken(String username) {
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9."
             + "eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0."
             + "KMUFsIDTnFmyG3nMiGM6H9FNFUROf3wh7SmqJp-QV30";
    }
}