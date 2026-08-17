package com.jsp.A12_Backup.util;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	private int status;
	private String msg;
	private T data;
}
