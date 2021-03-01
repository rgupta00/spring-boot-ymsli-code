package com.bookapp.service;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.bookapp.dao.BookDao;
import com.bookapp.dao.BookDaoImpl;

//@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

//	@Spy
//	BookDao dao;
//	
	@Spy
	BookDaoImpl dao;
	
	@InjectMocks
	BookServiceImpl bookService;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		//dao = mock(BookDao.class);
		//when somebody call getBooks method please return him List<String> containing data 
		when(dao.getBooks())
		.thenReturn(Arrays.asList("java", "rich dad poor dad", "java adv"));

	}

	@org.junit.Test
	public void getBookTest() {
		//bookService = new BookServiceImpl();
		//bookService.setBookDao(dao);

		List<String> books = bookService.getBooks("java");
		Assert.assertEquals(2, books.size());
	}

	@After
	public void after() {
		dao = null;
		bookService = null;

	}

}
