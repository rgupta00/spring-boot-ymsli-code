package com.bookapp.service;
import java.util.*;

import com.bookapp.dao.Book;

public interface BookService {
	public List<Book> getAll();
	public Book getById(int id);
	public Book addBook(Book book);
	public Book updateBook(int id, Book book);
	public Book deleteBook(int id);
	
}
