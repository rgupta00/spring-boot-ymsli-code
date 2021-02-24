package com.bookapp.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.bookapp.dto.ErrorMessage;
import com.bookapp.exception.BookNotFoundException;
@ControllerAdvice
@RestController
public class ExceptionHandlerContoller {

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ErrorMessage> getMessage(BookNotFoundException ex) {
		
		ErrorMessage errorMessage=new ErrorMessage();
		errorMessage.setContactMail("rgupta.mtech@mgail.com");
		errorMessage.setErrorMessage(ex.getMessage());
		errorMessage.setTimeStamp(new Date());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
	}
}
