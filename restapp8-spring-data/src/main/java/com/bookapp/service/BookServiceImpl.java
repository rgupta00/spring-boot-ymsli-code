package com.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.dto.Book;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.repository.BookRepository;
import com.bookapp.service.aspect.MyLogger;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	private BookRepository bookRepo;

	@Autowired
	public BookServiceImpl(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}

	@MyLogger
	@Override
	public Iterable<Book> getAllBooks() {
		System.out.println("---------getAllBooks is called--");
		return bookRepo.findAll();

	}

	@Cacheable(value = "mycache", key = "#bookId")
	@Override
	public Book getBookById(int bookId) {
		return bookRepo.findById(bookId).orElseThrow(()-> new BookNotFoundException
				("book with id "+ bookId +" is not found"));
	}

	@CachePut(value = "mycache", key = "#result.id")
	@Override
	public Book addBook(Book book) {
		 bookRepo.save(book);
		 return book;
	}

	@CachePut(value = "mycache", key = "#result.id")
	@Override
	public Book updateBook(int id, Book book) {
		Book bookToUpdate = getBookById(id);
		bookToUpdate.setPrice(book.getPrice());
		 bookRepo.save(bookToUpdate);
		 return bookToUpdate;
	}

	@CacheEvict(value = "mycache", key = "#bookId")
	@Override
	public Book removeBook(int bookId) {
		Book bookToDeleted=getBookById(bookId);
		bookRepo.delete(bookToDeleted);
		return bookToDeleted;
	}

	
	@CacheEvict(value = "mycache", allEntries = true)
	@Override
	public void evictCache() {
	}

}
