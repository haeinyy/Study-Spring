package com.ssafy.di.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ssafy.di.hello.Hello;
import com.ssafy.di.hello.HelloImpl;

// .java로 설정
@Configuration
@ComponentScan(basePackages = "com.ssafy.di")
public class ApplicationConfig {
	
//	@Bean
//	public Hello hello() {
//		Hello h new HelloImpl();
//		return h;
//	}
	

}
