package com.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.dao.BookDao;
import com.bookapp.dto.Book;
import com.bookapp.service.aspect.MyLogger;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	private BookDao bookDao;

	@Autowired
	public BookServiceImpl(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@MyLogger
	@Override
	public List<Book> getAllBooks() {
		System.out.println("---------getAllBooks is called--");
		List<Book> books= bookDao.getAllBooks();
		return books;
	
	}
	//hit the db if data is not there in cached.. otherwise retrun from cache
	//if not there in cached dont call actual service method
	@Cacheable(value = "mycache", key = "#bookId")
	@Override
	public Book getBookById(int bookId) {
		System.out.println("===========================================");
		System.out.println("---------getBookById is called--"+ bookId);
		return bookDao.getBookById(bookId);
	}

	@CachePut(value ="mycache" , key = "#result.id" )
	@Override
	public Book addBook(Book book) {
		return bookDao.addBook(book);
	}
	//hey cache framework when this method called it return a object let consider that 
	//object as "result" and looking inside object and u will find a field ie called "id"
	//take that as a key and store into cache.
	@CachePut(value ="mycache" , key = "#result.id" )
	@Override
	public Book updateBook(int id, Book book) {
		Book bookToUpdate=getBookById(id);
		bookToUpdate.setPrice(book.getPrice());
		return bookDao.updateBook(bookToUpdate);
	}

	@CacheEvict(value = "mycache", key = "#bookId")
	@Override
	public Book removeBook(int bookId) {
		return bookDao.removeBook(bookId);
	}

	// we want to apply some trick so that after periodic time this should called 
	//automcatically so that we have little chances of state cache
	
	//Scehduled process : spring 
	@CacheEvict(value = "mycache", allEntries = true)
	@Override
	public void evictCache() {}

	
}
