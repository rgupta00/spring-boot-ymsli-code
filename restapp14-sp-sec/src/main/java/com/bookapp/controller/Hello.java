package com.bookapp.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.dao.Message;

@RestController
public class Hello {

	@GetMapping(path = "home", produces = MediaType.APPLICATION_JSON_VALUE)
	public Message home() {
		return new Message("home");
	}
	
	@GetMapping(path = "admin",produces = MediaType.APPLICATION_JSON_VALUE)
	public Message admin() {
		return new Message("admin");
	}
	
	@GetMapping(path = "mgr",produces = MediaType.APPLICATION_JSON_VALUE)
	public Message mgr() {
		return new Message("mgr");
	}
	
	@GetMapping(path = "emp",produces = MediaType.APPLICATION_JSON_VALUE)
	public Message emp() {
		return new Message("emp");
	}
	
}
