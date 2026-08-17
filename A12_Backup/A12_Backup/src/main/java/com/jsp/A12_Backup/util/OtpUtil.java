package com.jsp.A12_Backup.util;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class OtpUtil {
	
	public String generateOtp() {
		Random random=new Random();
		int otp=10000+random.nextInt(90000);
		return String.valueOf(otp);  
	}
}
