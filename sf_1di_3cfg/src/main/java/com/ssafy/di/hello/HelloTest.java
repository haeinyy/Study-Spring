package com.ssafy.di.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class HelloTest {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(com.ssafy.di.cfg.ApplicationConfig.class);
		
		Hello h = (Hello) ctx.getBean("hello");
		h.sayHello("이해인");

		Hello h1 = ctx.getBean(Hello.class);
		h1.sayHello("이대균");

		Hello h2 = ctx.getBean(HelloImpl.class);
		h2.sayHello("사오정");
		
		// single 일때(객체 처음 하나만 생성) 다 true / prototype 일때 다 false 
		System.out.println(h==h1);
		System.out.println(h==h2);
		System.out.println(h2==h1);
		
		
		ctx.close();
	}

}
