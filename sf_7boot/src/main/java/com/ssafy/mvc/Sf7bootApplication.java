package com.ssafy.mvc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan(basePackages = "com.ssafy.mvc.model.repo")
public class Sf7bootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sf7bootApplication.class, args);
	}

}
