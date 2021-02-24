package com.bookapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookapp.dto.Book;
import com.bookapp.exception.BookNotFoundException;

@Repository
public class BookDaoImpl implements BookDao {

	private EntityManager em;

	@Autowired
	public BookDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Book> getAllBooks() {
		return em.createQuery("from Book", Book.class).getResultList();
	}

	@Override
	public Book getBookById(int bookId) {
		Book book= em.find(Book.class, bookId);
		if(book==null)
			throw new BookNotFoundException("book with id: "+ bookId+" is not found");
		return book;
	}
	

	@Override
	public Book addBook(Book book) {
		em.persist(book);
		return book;
	}

	@Override
	public Book updateBook(Book book) {
		em.merge(book);
		return book;
	}

	@Override
	public Book removeBook(int bookId) {
		Book bookToRemove = getBookById(bookId);
		em.remove(bookToRemove);
		return bookToRemove;
	}

}
