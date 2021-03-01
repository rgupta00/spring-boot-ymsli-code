package com.bookapp.dao;

import java.util.Arrays;
import java.util.List;

public class BookDaoImpl implements BookDao {
	@Override
	public List<String> getBooks() {
		log();
		return Arrays.asList("phy", "rich dad poor dad", "maths adv");
	}

	public void log() {
		System.out.println("---------this is not called-----");
	}
}