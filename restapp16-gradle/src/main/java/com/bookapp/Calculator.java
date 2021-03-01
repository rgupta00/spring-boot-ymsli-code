package com.bookapp;

public class Calculator {
	
	public String slowApi() {
		try {
			Thread.sleep(800);
		}catch(InterruptedException ex) {}
		return "json resp";
	}
	public int add(int a, int b) {
		return a+b;
	}
    public int divide(int n1, int n2){
        return n1/n2;
    }
}
