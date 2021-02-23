package com.bookapp.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.dao.Book;
import com.bookapp.model.service.BookService;

@RestController
@RequestMapping(path = "api")
public class BookRestController {

	private BookService bookService;

	@Autowired
	public BookRestController(BookService bookService) {
		this.bookService = bookService;
	}
	
	
	@PostConstruct
	public void addbook() {
		bookService.addBook(new Book("3WA", "java is fun", "raj", 500));
		bookService.addBook(new Book("3WQ", "spring in action", "foo", 500));
		
	}
	
	
	@GetMapping(path = "book", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@GetMapping(path = "book/{bid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book getAnBook(@PathVariable(name="bid") int bookId){
		return bookService.getBookById(bookId);
	}
	@PostMapping(path="book", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes =  MediaType.APPLICATION_JSON_VALUE)
	
	public Book addBook( @RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	@PutMapping(path="book/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes =  MediaType.APPLICATION_JSON_VALUE)
	public Book updateBook(@PathVariable(name = "id") int id,  @RequestBody Book book) {
		return bookService.updateBook(id, book);
	}
	
	@DeleteMapping(path="book/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Book deleteBook(@PathVariable(name = "id") int id) {
		return bookService.removeBook(id);
	}
}


/*
 * @PathVariable vs @RequestParam
 * @PathVariable: is used to get varable part of the path
 * 
 * http://localhost:8080/mvcrest/api/book/1/author/1
 */


/*
 * 
 * @RequestBody: it used to tell spring to convert the recived json to java object
 * @RequestBody: it is used to tell sring to convert java to json object
 * 
 * @RestController=@Controller+ @ResponseBody(it invoke parser and use it to conver java ---> json
 */







