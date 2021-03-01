package com.bookapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
@DisplayName("test for employee dao")
public class TestEmployee {

	@DisplayName("test for updating emp object")
	//@Order(value = 1)
	//@RepeatedTest(value = 3,name="{displayName} - {currentRepetition}/{totalRepetitions}") ?
	@RepeatedTest(value = 3)
	@Test
	public void testUpdate(TestInfo testInfo) {
		System.out.println("updating ");
	}
	
//	@Order(value = 1)
//	@Test
//	public void testSave() {
//		System.out.println("saving");
//	}
//	
//	
//	
//	@Order(value = 2)
//	@Test
//	public void testDelete() {
//		System.out.println("deleting");
//	}
}