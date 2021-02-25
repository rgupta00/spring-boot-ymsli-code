package com.bookapp.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.startup.SetAllPropertiesRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bookapp.dto.ErrorMessage;
import com.bookapp.exception.BookNotFoundException;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;
@Api(hidden = true)
@ControllerAdvice
@RestController
public class ExceptionHandlerContoller extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleBookNotFoundEx(BookNotFoundException ex) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setContactMail("rgupta.mtech@mgail.com");
		errorMessage.setErrorMessage(ex.getMessage());
		errorMessage.setTimeStamp(new Date());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DataAccessException.class)
	public ResponseEntity<ErrorMessage> dbExHandler(Exception ex) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setContactMail("rgupta.mtech@mgail.com");
		System.out.println("--------------------------");
		System.out.println(ex);
		System.out.println("--------------------------");
		errorMessage.setErrorMessage("some db hell happens  :(");
		errorMessage.setTimeStamp(new Date());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> genericExHandler(Exception ex) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setContactMail("rgupta.mtech@mgail.com");
		System.out.println("--------------------------");
		System.out.println(ex);
		System.out.println("--------------------------");
		errorMessage.setErrorMessage("some server side error try after some time");
		errorMessage.setTimeStamp(new Date());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		//how to deal 
		BindingResult bindingResult = ex.getBindingResult();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		
		StringBuilder builder=new StringBuilder("validation failed for : ");
		
		for(FieldError fe:fieldErrors ) {
			builder.append(fe.getField()).append(" ,");
			
		}
		
		ErrorMessage errorMessage = new ErrorMessage(builder.toString(), 
				"rg@gmail.com", new Date());
		return new ResponseEntity<Object>(errorMessage, HttpStatus.BAD_REQUEST);
	}

}
