package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.bookapp.dto.Book;
import com.bookapp.service.BookService;
@EnableAspectJAutoProxy
@SpringBootApplication
public class Restapp2Basics2Application implements CommandLineRunner{

	@Autowired
	private BookService bookDao;
	
	public static void main(String[] args) {
		SpringApplication.run(Restapp2Basics2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//bookDao.addBook(new Book("AQ12", "spring in action", "foo", 560));
		//bookDao.addBook(new Book("AQM", "hib in action", "bar", 560));
		
	}

}
