package com.jsp.movies.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public String getExceptionMsg(MethodArgumentNotValidException e) {
		return e.getFieldError().getDefaultMessage();
	}
}