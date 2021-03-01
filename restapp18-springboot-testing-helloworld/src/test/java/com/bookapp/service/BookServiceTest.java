package com.bookapp.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.dao.BookDao;
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

	@Mock
	BookDao dao;
	
	@InjectMocks
	BookServiceImpl bookService;

	@BeforeEach
	public void before() {
		dao = mock(BookDao.class);
		when(dao.getBooks()).thenReturn(Arrays.asList("java", "rich dad poor dad", "java adv"));

	}

	@Test
	public void getBookTest() {
		//bookService = new BookServiceImpl();
		//bookService.setBookDao(dao);

		List<String> books = bookService.getBooks("java");
		Assertions.assertEquals(2, books.size());
	}

	@AfterEach
	public void after() {
		dao = null;
		bookService = null;

	}

}
