package com.jsp.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailVerificataion {
	@Autowired
	JavaMailSender javaMailSender;
	
	public void verifyEmail(String toEmail, String otp) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("densil.raja@gmail.com");
		message.setTo(toEmail);
		message.setSubject("Enter this OTP to login :");
		message.setSubject("Your otp will be expire in 10 minutes");
		message.setText(otp);
		javaMailSender.send(message);
	}
}
