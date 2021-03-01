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
public class BookController {
	
	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	@GetMapping(path = "book", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> getAllBooks(){
		return bookService.getAll();
	}
	
	@GetMapping(path = "book/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book getAnBooks(@PathVariable(name = "id") int id){
		return bookService.getById(id);
	}
	
	@PostMapping(path = "book", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes =MediaType.APPLICATION_JSON_VALUE )
	public Book postAnBooks( @RequestBody Book book){
		return bookService.addBook(book);
	}
	
	@DeleteMapping(path = "book/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes =MediaType.APPLICATION_JSON_VALUE )
	public void deleteAnBooks(@PathVariable(name = "id") int id){
		 bookService.deleteBook(id);
	}
	
	
	@PutMapping(path = "book/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes =MediaType.APPLICATION_JSON_VALUE )
	public Book updateAnBooks(@PathVariable(name = "id") int id, @RequestBody Book book){
		return bookService.updateBook(id, book);
	}
	
}
