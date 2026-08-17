package com.jsp.A12_Backup.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Name Should Not Be Blank")
	@Size(min=3,max=20, message ="Enter Min 3 and Max 20 character" )
	private String name;
	
	@NotBlank(message = "Category should not be blank")
	private String category;
	
	@Positive(message = "price should be positive")
	private double price;
	
	@Email(message = "Email should be in proper format")
	private String email;
	
	@Pattern(regexp = "[0-9]{10}",message = "Mobile Number should contain 10 digits")
	private String mobile;
	
}
