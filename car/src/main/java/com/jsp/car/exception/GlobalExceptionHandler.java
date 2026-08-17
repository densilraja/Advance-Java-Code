package com.jsp.car.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(BrandNotFound.class)
    public String BNFE(BrandNotFound e){
        return e.getMessage();
    }
}
