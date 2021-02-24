package com.bookapp.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CollectionId;
import org.springframework.format.annotation.DateTimeFormat;

import net.bytebuddy.implementation.auxiliary.AuxiliaryType.SignatureRelevant;

@Entity
@Table(name = "book_table_mvc_boot2")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String isbn;
	
	@Size(message = "title should be of min 5 char", min = 5)
	private String title;
	
	@Size(message = "author should be of min 5 char", min = 5)
	private String author;
	
	
	private double price;

	@Past
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;
	
	
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Book() {}

	public Book(String isbn, @Size(message = "title should be of min 5 char", min = 5) String title,
			@Size(message = "author should be of min 5 char", min = 5) String author, double price, LocalDate date) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.date = date;
	}

	
}