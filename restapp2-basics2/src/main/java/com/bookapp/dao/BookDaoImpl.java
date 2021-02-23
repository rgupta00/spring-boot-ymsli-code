package com.bookapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		// get vs find: eager
		// load vs getReference

		return em.find(Book.class, bookId);
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
