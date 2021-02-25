package com.bookapp.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.bookapp.dto.Book;
//@Slf4j
//@Service
public class ScheduledJob {
	
	private Logger logger=LoggerFactory.getLogger(ScheduledJob.class);
	
	private BookService bookService;

	@Autowired
	public ScheduledJob(BookService bookService) {
		this.bookService = bookService;
	}
	@Scheduled(cron = "0,30 * * * * *")
	public void cronJob() {
		logger.info("called after every 30 sec");
		bookService.evictCache();
	}
	//hey sch call it after initial delay of 5000 ms and then repeat this job at fixed rate of 15000
	@Scheduled(initialDelay = 5000, fixedRate = 15000 )
	public void fixedRateJob() {
		logger.info("> fixedRateJob");

		// Add scheduled logic here

		Iterable<Book> greetings = bookService.getAllBooks();
		logger.info("There are {} books in the data store.");

		logger.info("< fixedRateJob");
	}
}
