package com.jsp.car.exception;

public class BrandNotFound extends RuntimeException {
    
    public String getMessage(){
        return "Brand Not Found";
    }
}
