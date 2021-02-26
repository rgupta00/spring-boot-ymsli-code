package com.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//$2a$12$3CeIGFRHbCQVZDZphaXvAur//WZyMbFXFoAgmRzHZSc7LbDmtYKOK
//$2a$12$qYn0L9G5F7iTUWJaKqSJveiJ4LNSm/lYxUDYab2R3ftiUxuOHeKle
public class Main {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
		System.out.println(encoder.encode("emp"));
		
	}
}
