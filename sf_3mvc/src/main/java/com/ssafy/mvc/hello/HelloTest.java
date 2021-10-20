package com.ssafy.mvc.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloTest {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		
		Hello h = (Hello) ctx.getBean("hello");
		h.sayHello("이해인");
		
		ctx.close();
	}

}
