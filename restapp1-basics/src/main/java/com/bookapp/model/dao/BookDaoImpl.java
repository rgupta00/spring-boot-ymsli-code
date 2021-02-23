package com.bookapp.model.dao;

import java.util.*;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository //@Comonent + exction trannlaction
public class BookDaoImpl implements BookDao {

	private EntityManager em;
	
	@Autowired
	public BookDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Book> getAllBooks() {
		return em.createQuery("select b from Book b", Book.class).getResultList();
	}

	@Override
	public Book getBookById(int bookId) {
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
		Book bookToBeDeleted=getBookById(bookId);
		em.remove(bookToBeDeleted);
		return bookToBeDeleted ;
	}

}
