package com.bookapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.dao.Book;
import com.bookapp.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
@Transactional
@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerIntegrationTest {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	
	
	@Test
	public void testAddBook() throws Exception{
		Book bookAdded= new Book("life in action", "raj", 500.00);
		
		String jsonStringBookAdded=objectMapper.writeValueAsString(bookAdded);
		
		String url="/book";
		mockMvc.perform(post(url)
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(bookAdded))
				)
				.andExpect(status().isOk());				
	}
	
}
