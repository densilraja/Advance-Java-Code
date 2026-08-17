package com.jsp.library_management.exception;

public class DataNotFound extends RuntimeException{
	
	@Override
	public String getMessage() {
		return "Book Data Not Found";
	}
	
}
