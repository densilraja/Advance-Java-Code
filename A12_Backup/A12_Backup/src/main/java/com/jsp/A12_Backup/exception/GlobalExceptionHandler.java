package com.jsp.A12_Backup.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ProductNotFound.class)
	public String PNFE(ProductNotFound found) {
		return found.getMessage();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public String methodValid(MethodArgumentNotValidException e) {
		return e.getFieldError().getDefaultMessage();
	}

}
