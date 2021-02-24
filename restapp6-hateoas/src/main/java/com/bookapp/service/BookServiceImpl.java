package com.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
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
		List<Book> books= bookDao.getAllBooks();
		return books;
	
	}

	@Override
	public Book getBookById(int bookId) {
		return bookDao.getBookById(bookId);
	}

	
	@Override
	public Book addBook(Book book) {
		return bookDao.addBook(book);
	}

	@Override
	public Book updateBook(int id, Book book) {
		Book bookToUpdate=getBookById(id);
		bookToUpdate.setPrice(book.getPrice());
		return bookDao.updateBook(bookToUpdate);
	}

	@Override
	public Book removeBook(int bookId) {
		return bookDao.removeBook(bookId);
	}

}
