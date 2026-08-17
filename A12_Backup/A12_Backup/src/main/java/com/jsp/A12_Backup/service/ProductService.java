package com.jsp.A12_Backup.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jsp.A12_Backup.entity.Product;
import com.jsp.A12_Backup.exception.ProductNotFound;
import com.jsp.A12_Backup.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	@Autowired
	ProductRepo  repo;
	
	public Product saveProduct(Product p) {
		return repo.save(p);
	}
	
	public Product findByname(String name) {
		return repo.findByname(name);
	}
	
	public List<Product> findByPrice(double price){
		return repo.findBypriceGreaterThan(price);
	}
	
	public Product findById(int id) {
		 Optional<Product> p = repo.findById(id);
		 if(p.isPresent()) {
			 return p.get();
		 }
		 throw new ProductNotFound();
	}
	
	public void sendEmail(String toemail,String otp) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("akankshadesai932@gmail.com");
		message.setTo(toemail);
		message.setSubject("otp sent successfully");
		message.setText(otp);
		javaMailSender.send(message);
	}
}
