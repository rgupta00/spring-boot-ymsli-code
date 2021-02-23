package com.bookapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.dao.Book;
import com.bookapp.service.BookService;

@RestController
public class BookRestController {

	private BookService bookService;

	@Autowired
	public BookRestController(BookService bookService) {
		this.bookService = bookService;
	}

	// ========get all books==========
	@GetMapping(path = "book", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	// ========get an book by id==========
	@GetMapping(path = "book/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book getAnBook(@PathVariable(name = "id") int bookId) {
		return bookService.getBookById(bookId);
	}

	// ========add a book==========
	@PostMapping(path = "book", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Book addAnBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}

	// ========update a book==========
	@PutMapping(path = "book/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Book updateAnBook(@PathVariable(name = "id") int bookId, @RequestBody Book book) {
		return bookService.updateBook(bookId, book);
	}
	
	

	// ========delete an book by id==========
	@DeleteMapping(path = "book/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book deleteAnBook(@PathVariable(name = "id") int bookId) {
		return bookService.removeBook(bookId);
	}

}
