package com.jsp.A12_Backup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.A12_Backup.entity.Product;
import com.jsp.A12_Backup.service.ProductService;
import com.jsp.A12_Backup.util.OtpUtil;
import com.jsp.A12_Backup.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	
	@Autowired
	OtpUtil otpUtil;
	
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@Valid @RequestBody Product p) {
		Product product = productService.saveProduct(p);
		ResponseStructure<Product> rs=new ResponseStructure<Product>();
		rs.setStatus(HttpStatus.CREATED.value());
		rs.setMsg("Data Inserted Successfully");
		rs.setData(product);
		return new ResponseEntity<>(rs,HttpStatus.CREATED);
	}
	
	@GetMapping("/find/{name}")
	public ResponseEntity<ResponseStructure<Product>>  findByname(@PathVariable String name) {
		 Product product = productService.findByname(name);
		 ResponseStructure<Product> rs=new ResponseStructure<Product>();
		 if(product!=null) {
			 rs.setStatus(HttpStatus.OK.value());
			 rs.setData(product);
			 rs.setMsg("Data Displayed");
			 return  new ResponseEntity<>(rs,HttpStatus.OK);
		 }
		 else {
			 rs.setStatus(HttpStatus.NOT_FOUND.value());
			 rs.setData(product);
			 rs.setMsg("Data Not Found");
			 return  new ResponseEntity<>(rs,HttpStatus.NOT_FOUND);
		 }
	}
	
	@GetMapping("/findp")
	public List<Product> findByPrice(@RequestParam double price){
		return productService.findByPrice(price);
	}
	
	@GetMapping("/findb/{id}")
	public Product findById(@PathVariable int id) {
		return productService.findById(id);
	}
	
	@GetMapping("/email/{toEmail}")
	public String sendMail(@PathVariable String toEmail) {
		String otp = otpUtil.generateOtp();
		 productService.sendEmail(toEmail, otp);
		 return "OTP SENT SUCCESSFULLY";
	}
}
