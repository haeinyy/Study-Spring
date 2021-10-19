package com.ssafy.di.hello;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component("hello")
public class HelloImpl implements Hello {
	
	public HelloImpl() {
		System.out.println("HelloImpl()");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("HelloImpl.init()");
	}

	@Override
	public void sayHello(String name) {
		System.out.println(name+",안녕하세요^^");
	}
	
	@PreDestroy
	public void destory() {
		System.out.println("HelloImpl.destory()");
	}
}
