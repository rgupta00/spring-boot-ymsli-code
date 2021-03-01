package com.bookapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CalculatorTest1 {

	private Calculator calculator;

	@BeforeEach
	void setUp() throws Exception {
		calculator = new Calculator();
	}

	@Test
	
	
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @CsvFileSource(resources = "/test-data.csv")
    void sum(int a, int b, int sum) {
        Assertions.assertEquals(sum, a + b);
    }
}
