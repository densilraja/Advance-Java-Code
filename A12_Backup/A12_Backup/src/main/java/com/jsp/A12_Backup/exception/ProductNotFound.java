package com.jsp.A12_Backup.exception;

public class ProductNotFound extends RuntimeException{

	@Override
	public String getMessage() {
		return "Product Not Found";
	}
}
