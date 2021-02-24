package com.bookapp.dao;

import java.util.List;

import com.bookapp.dto.Book;

public interface BookDao{
    public List<Book> getAllBooks();
    public Book getBookById(int bookId);
    public Book addBook(Book book);
    public Book updateBook(Book book);
    public Book removeBook(int bookId);
}