package com.bookapp;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	private Calculator calculator;
	

	@BeforeEach
	void setUp() throws Exception {
		calculator=new Calculator();
	}

	@Test
	public void testSlowApi() {
		Assertions.assertTimeout(Duration.ofMillis(500),
				()-> calculator.slowApi());
	}

	@Test
	void testAddTest() {
		Assertions.assertEquals(4, calculator.add(2, 2));
		System.out.println("-----------------------");
	}
	
	@Test
	void testDivideTest() {
		Assertions.assertThrows(ArithmeticException.class, ()-> calculator.divide(4, 0));
		System.out.println("-----------------------");
	}
	
	
	@AfterEach
	void tearDown() throws Exception {
		calculator=null;
		
	}





}
