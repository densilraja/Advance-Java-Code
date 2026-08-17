package com.jsp.library_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String Book_Name;
	private String Author;
	private Double price;
	private Integer quantituy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBook_Name() {
		return Book_Name;
	}

	public void setBook_Name(String book_Name) {
		Book_Name = book_Name;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantituy() {
		return quantituy;
	}

	public void setQuantituy(int quantituy) {
		this.quantituy = quantituy;
	}

}
