package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.dao.Book;
import com.bookapp.service.BookService;

@SpringBootApplication
public class Demo1Application implements CommandLineRunner {

	@Autowired
	private BookService bookService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book=new Book("java", "raj", 500.00);
		Book book2=new Book("python", "ekta", 600.00);
		
//		bookService.addBook(book);
//		bookService.addBook(book2);
//		
//		System.out.println("-----------");
		
		
		
	}

}
