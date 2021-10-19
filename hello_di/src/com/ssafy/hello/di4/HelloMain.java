package com.ssafy.hello.di4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		System.out.println("main start!!");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/ssafy/hello/di4/applicationContext.xml");
//		ApplicationContext context = new GenericXmlApplicationContext("com/ssafy/hello/di4/applicationContext.xml");
		System.out.println("xml read ok!!");
//		HelloMessage helloMessage = (HelloMessage) context.getBean("kor");
		HelloMessage helloMessage = context.getBean("kor", HelloMessageKor.class);
//		HelloMessage helloMessage = context.getBean("eng", HelloMessageEng.class);
		
		String greeting = helloMessage.hello("안효인");
//		String greeting = helloMessage.hello("Mr. An");
		
		System.out.println(greeting);
		
//		System.out.println("----------------------------------------");
		
		HelloMessage kor1 = context.getBean("kor", HelloMessageKor.class);
		HelloMessage kor2 = context.getBean("kor", HelloMessageKor.class);
		System.out.println(kor1 + " ::::: " + kor2);
	}
	
}
