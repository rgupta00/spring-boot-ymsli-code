package com.bookapp;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NamedQueries;

@Entity
@Table(name = "b_table")
@NamedQuery(name="Book.getAll", query = "select b from Book b")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	
	private String title;
	@Temporal(TemporalType.DATE)
	private Date publishDate;
	private int pageCount;
	private double price;
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Book(String title, Date publishDate, int pageCount, double price) {
		super();
		this.title = title;
		this.publishDate = publishDate;
		this.pageCount = pageCount;
		this.price = price;
	}
	public Book() {}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", publishDate=" + publishDate + ", pageCount="
				+ pageCount + ", price=" + price + "]";
	}
	
	
	
}
