package com.bookapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.dto.Book;
import com.bookapp.exception.BookNotFoundException;
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
	public ResponseEntity<Iterable<Book>> getAllBooks() {
		Iterable<Book> books= bookService.getAllBooks();
		//System.out.println(1/0);
		return new ResponseEntity<Iterable<Book>>(books, HttpStatus.OK);
	}
	

	// ========get an book by id==========
	@GetMapping(path = "book/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> getAnBook(@PathVariable(name = "id") int bookId) {
		return ResponseEntity.ok(bookService.getBookById(bookId));
	}

	// ========add a book==========
	@PostMapping(path = "book", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> addAnBook(@Valid  @RequestBody Book book) {
		Book bookAdded= bookService.addBook(book);
		return new ResponseEntity<Book>(bookAdded, HttpStatus.CREATED);
	}

	// ========update a book==========
	@PutMapping(path = "book/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book>  updateAnBook(@PathVariable(name = "id") int bookId, @RequestBody Book book) {
		return new ResponseEntity<Book>(bookService.updateBook(bookId, book), HttpStatus.OK);
	}

	// ========delete an book by id==========
	@DeleteMapping(path = "book/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteAnBook(@PathVariable(name = "id") int bookId) {
		 bookService.removeBook(bookId);
		 return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
