package com.demo;
import java.util.*;
//@FunctionalInterface
//interface Foo{
//	void foof2();
//	void foof();
//}
class A{
	void foo() {
		System.out.println("foo is called");
	}
	@Deprecated
	public void doLogicOld() {
		System.out.println("old stuff 2008");
	}
}

class B extends A{
	
	@SuppressWarnings({"unchecked","rawtypes"})
	@Override
	void foo() {
		List list=new ArrayList();
		list.add("demo");
		list.add("demo2");
		System.out.println("foo overriden is called");
	}
	
	public void doLogicNew() {
		System.out.println("old stuff 2020");
	}
}


/*
 * anno: aka meta data!
 * 
 * java defined anno: Override, FI, Deprecated, 
 * 
 * custom anno: when u create ur own framework u want to have some meta data 
 * 	so that u can process client code accoring to what ann they have applied
 * 
 */
public class AnnoRevision {
	
	public static void main(String[] args) {
		A a=new B();
		a.doLogicOld();
		
		Date date=new Date();
		System.out.println(date.getDate());
	}

}
