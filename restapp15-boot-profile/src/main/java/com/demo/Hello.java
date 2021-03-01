package com.demo;
import java.util.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

	@Value("${hello.message: default value}")
	private String info;
	@Value("${my.list.values}")
	private List<String> values;
	
	@GetMapping(path = "hello")
	public String hello() {
		
		return "hello "+ info+ values;
	}
}
