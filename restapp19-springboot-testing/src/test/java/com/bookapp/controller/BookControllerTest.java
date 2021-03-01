package com.bookapp.controller;
import static org.mockito.Mockito.RETURNS_SELF;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.bookapp.dao.Book;
import com.bookapp.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

//RestController --service -- repo--db

@WebMvcTest(BookController.class)
public class BookControllerTest {
	
	//this is used to provide power to mvc controller
	@Autowired
	private MockMvc mockMvc;
	
	//hey spring in need to get mock object of service layer : as i am doing unit testing
	
	@MockBean
	private BookService bookService;
	
	//it is used to convert java object <==> json
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void allBookTest() throws Exception {
		List<Book>books=Arrays.asList(new Book("java", "raj", 500.00),
				new Book("python", "ekta", 600.00));
		when(bookService.getAll()).thenReturn(books);
		
		mockMvc.perform(get("/book")).andExpect(status().isOk());
		
	}
	
	
	@Test
	public void allBookTest2() throws Exception {
		
		List<Book>books=Arrays.asList(new Book("java", "raj", 500.00),
				new Book("python", "ekta", 600.00));
		
		when(bookService.getAll()).thenReturn(books);
		
		MvcResult result = mockMvc.perform(get("/book"))
		.andExpect(status().isOk())
		.andReturn();
		
		//convert that resp to string
		
		String actualJsonResponse= result.getResponse().getContentAsString();
		
		System.out.println(actualJsonResponse);
		
		//this the resp for that endpoint is same as the data that i mock in service 
		//layer
		
		String expectedJsonResponse=objectMapper.writeValueAsString(books);
		
		Assertions.assertEquals(actualJsonResponse, expectedJsonResponse);
	}
}


















