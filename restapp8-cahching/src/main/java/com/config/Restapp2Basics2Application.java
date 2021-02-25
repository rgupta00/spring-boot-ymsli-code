package com.config;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bookapp.dto.Book;
import com.bookapp.service.BookService;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableScheduling
@EnableAspectJAutoProxy
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan({ "com.bookapp", "com.config" })
@EntityScan("com.bookapp.dto")
public class Restapp2Basics2Application implements CommandLineRunner {

	@Autowired
	private BookService bookDao;

	public static void main(String[] args) {
		SpringApplication.run(Restapp2Basics2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		bookDao.addBook(new Book("AQ12", "spring in action", "rajeev gupta", 560, LocalDate.of(2017, Month.APRIL, 12)));
//		bookDao.addBook(new Book("AQM", "hib in action", "ekta gupta", 560, LocalDate.of(2020, Month.APRIL, 22)));

	}

}
