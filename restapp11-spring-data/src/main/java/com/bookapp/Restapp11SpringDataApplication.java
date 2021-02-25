package com.bookapp;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Restapp11SpringDataApplication implements CommandLineRunner {

	@Autowired
	private BookRepo bookRepo;

	public static void main(String[] args) {
		SpringApplication.run(Restapp11SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// addBooks();
		// findAll();
		// getById();
		// update();

		//existById();
		
		//findByIdDemo();
		
		//bulk add, bulk delete
		
		//custome methods1
		//findByTitle
//		List<Book>books=bookRepo.findByTitle("java basics");
//		books.forEach(b-> System.out.println(b));

		//simpleMethodQuaries();
		
		//comarisionOp
		//ComparisionOp();
		
		//findByPublishDateBetweenDemo
		//findByPublishDateBetweenDemo();
		
		//findTop2ByOrderByPriceDesc
		
		//getAllBooks1: Quaries @Query
		
		
		
		
     	List<Book>books=bookRepo.getAllBooks1Native();
     	
		books.forEach(b-> System.out.println(b));
		
	}

	private void findByPublishDateBetweenDemo() throws ParseException {
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

		Date d1 = fmt.parse("1/10/2020");
		Date d2 = fmt.parse("16/2/2021");
		
		List<Book>books=bookRepo.findByPublishDateBetween(d1, d2);
		books.forEach(b-> System.out.println(b));
	}

	private void ComparisionOp() {
		List<Book>books=bookRepo.findByPageCountBetween(300, 390);
		books.forEach(b-> System.out.println(b));
	}

	private void simpleMethodQuaries() {
		System.out.println("------------------");
		List<Book>books=bookRepo.findByTitleLike("%java%");
		books.forEach(b-> System.out.println(b));
	}

	private void findByIdDemo() {
		//find by ids
		Iterable<Book>books=bookRepo.findAllById(Arrays.asList(1L, 2L, 3L));
		books.forEach(b-> System.out.println(b));
	}

	private void existById() {
		//existsById
		if (bookRepo.existsById(2L)) {
			System.out.println("book is found");
		} else
			System.out.println("book is not found");
	}

	private void update() {
		// update
		Book book = bookRepo.findById(2L).orElseThrow(() -> new ResourceNotFoundException());
		book.setPrice(book.getPrice() + 100);
		bookRepo.save(book);
	}

	private void getById() {
		// get a particular book

//	Optional<Book>bookOp= bookRepo.findById(25L);
//	System.out.println(bookOp.map(b->b.getTitle()).orElse("book not found"));

//	Book book=bookRepo.findById(20L).orElseThrow(()-> new ResourceNotFoundException());
		// System.out.println(book);
	}

	private void findAll() {
		// get all books
		bookRepo.findAll().forEach(b -> System.out.println(b));
	}

	private void addBooks() throws ParseException {
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

		Date d1 = fmt.parse("11/12/2019");
		Date d2 = fmt.parse("1/10/2018");
		Date d3 = fmt.parse("7/3/2019");
		Date d4 = fmt.parse("16/2/2021");
		// how to add rec
		bookRepo.save(new Book("java basics", d1, 300, 500.00));
		bookRepo.save(new Book("java adv", d1, 500, 600.00));
		bookRepo.save(new Book("spring basics", d2, 360, 580.00));
		bookRepo.save(new Book("physics basics", d3, 390, 510.00));
		bookRepo.save(new Book("hibernate basics", d4, 600, 700.00));
	}

}
