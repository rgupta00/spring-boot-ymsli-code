package com.bookapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@DisplayName("test for employee dao")
public class TestEmployeeTag {

	@DisplayName("test for saving employee dao")
	@Test
	public void testSave(TestInfo info) {
		System.out.println(info.getTestMethod().toString());
		System.out.println("saving");
	}

	@Tag(value = "dev")
	@Test
	public void testUpdate() {
		System.out.println("updating ");
	}

	@Tag(value = "prod")
	@Test
	public void testDelete() {
		System.out.println("deleting");
	}
}


