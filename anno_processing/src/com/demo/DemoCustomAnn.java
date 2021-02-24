package com.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno{
	public String hello() default "hello to ymsli dev";
	public boolean isSyllabusDone() default false;
}

class MyClass{
	
	@MyAnno(hello = "hello to ymsli champ",isSyllabusDone = true)
	public void foof() {
		System.out.println("i am the foof method ....");
	}
	
	public void bar() {
		System.out.println("i am the bar method ....");
	}
}
public class DemoCustomAnn {

	
	public static void main(String[] args) throws ClassNotFoundException {
		//Why to create custom anno
		// u want to crate a java based sw product 
		//framewwork: hibernate 
		
		//annotation + java reflection + byte code manipulation api (javaassist)
		
		//3 way to get meta data of the class
//		Class class1=MyClass.class;
//		
//		MyClass ob=new MyClass();
//		
//		Class<?> class2=ob.getClass();
		
		
		Class class1=Class.forName("com.demo.MyClass");
		
		Constructor[]constructors=class1.getConstructors();
		
		Method[] methods=class1.getDeclaredMethods();
		
		for(Method method: methods) {
			System.out.println(method.getName());
			if(method.isAnnotationPresent(MyAnno.class)) {
				MyAnno annotation = method.getAnnotation(MyAnno.class);
				System.out.println(annotation.isSyllabusDone()+": "+ annotation.hello());
			}
		}
		
	}
}
