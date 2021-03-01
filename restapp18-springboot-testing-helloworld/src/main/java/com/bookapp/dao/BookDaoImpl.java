package com.bookapp.dao;

import java.util.Arrays;
import java.util.List;

public class BookDaoImpl implements BookDao {
	@Override
	public List<String> getBooks() {
		System.out.println("---------this is not called-----");
		return Arrays.asList("java","rich dad poor dad","java adv");
	}
}