package com.shiyanlou.java8;

public class ScopeOfNewFeatures {
	final static String salutation="Hello!";
	public static void main(String args[]){
		GreetingService greetService1=message->
		System.out.println(salutation + message);
		greetService1.sayMessage(" shiyanlou");
	}
	
	interface GreetingService{
		void sayMessage(String message);
	}

}
