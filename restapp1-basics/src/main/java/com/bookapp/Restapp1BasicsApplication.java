package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bookapp.model.dao.Book;
import com.bookapp.model.service.BookService;



@SpringBootApplication
public class Restapp1BasicsApplication implements CommandLineRunner {

	@Autowired
	private BookService bookService;
	
	public static void main(String[] args) {
		SpringApplication.run(Restapp1BasicsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * bookService.addBook(new Book("AQ12", "java basics", "raj", 500));
		 * bookService.addBook(new Book("AU12", "spring in action", "foo", 500));
		 */
	}

}
