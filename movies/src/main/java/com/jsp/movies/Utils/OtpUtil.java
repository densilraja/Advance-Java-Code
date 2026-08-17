package com.jsp.movies.Utils;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class OtpUtil {
	public String generateOtp() {
		Random random = new Random();
		int nextInt = 100000 + random.nextInt(900000);
		return String.valueOf(nextInt);
	}
}
