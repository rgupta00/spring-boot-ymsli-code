package com.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Hello {

	@GetMapping(path ="home")
	public String sayHome(ModelMap model) {
		model.addAttribute("greeting", "hello home");
		return "home";
	}
	@GetMapping(path ="emp")
	public String sayHello(ModelMap model) {
		model.addAttribute("greeting", "hello emp");
		return "emp";
	}

	@GetMapping(path ="admin")
	public String sayhome(ModelMap model) {
		model.addAttribute("greeting", "Hello admin");
		return "admin";
	}

	@GetMapping("/showLoginPage")
	public String showLoginPage(){
		return "login_page";
	}
}
