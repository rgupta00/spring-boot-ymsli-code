package com.bookapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

	@GetMapping(path = "hello")
	public String hello() {
		return "hello to spring rest with gradle project";
	}
}
