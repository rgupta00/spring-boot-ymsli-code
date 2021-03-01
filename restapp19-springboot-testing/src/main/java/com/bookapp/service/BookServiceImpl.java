package com.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.dao.Book;
import com.bookapp.dao.BookRepo;
import com.bookapp.exception.BookNotFoundException;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	private BookRepo bookRepo;
	
	
	@Autowired
	public BookServiceImpl(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}

	@Override
	public List<Book> getAll() {
		return bookRepo.findAll();
	}

	@Override
	public Book getById(int id) {
		return bookRepo.findById(id).orElseThrow(BookNotFoundException::new);
	}

	@Override
	public Book addBook(Book book) {
		bookRepo.save(book);
		return book ;
	}

	@Override
	public Book updateBook(int id, Book book) {
		Book bookToUpdate=getById(id);
		bookToUpdate.setPrice(book.getPrice());
		bookRepo.save(bookToUpdate);
		return bookToUpdate;
	}

	@Override
	public Book deleteBook(int id) {
		Book bookToDelete=getById(id);
		bookRepo.delete(bookToDelete);
		return bookToDelete;
	}

}
