package com.jsp.library_management.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DataNotFound.class)
	public String DataNotFoundException(DataNotFound e) {
		return e.getMessage();
	}
	
}
