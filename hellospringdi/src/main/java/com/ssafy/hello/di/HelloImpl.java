package com.ssafy.hello.di;

public class HelloImpl implements Hello {
	
	public HelloImpl() {
		System.out.println("HelloImpl()");
	}
	
	@Override
	public void sayHello(String name) {
		System.out.println(name+", 안녕하세요!");

	}
}
