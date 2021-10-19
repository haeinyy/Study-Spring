package com.ssafy.hello.di;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloTest {

	public static void main(String[] args) {
		
//		Hello h = new HelloImpl();
//		h.sayHello("이해인");
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("root-context.xml");
		Hello h = (Hello)ctx.getBean("hello");
		h.sayHello("홍길동");
	}

}
