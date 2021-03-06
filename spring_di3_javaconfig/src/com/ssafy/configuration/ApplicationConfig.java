package com.ssafy.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

// xml을 대신하는 설정하는 파일인것 알려주기
@Configuration
@ComponentScan(basePackages = {"com.ssafy.model"}) // 찾아야할 패키지 파일 알려주기
public class ApplicationConfig {
	
	@Bean
	public DataSource getDataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/ssafyweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8");
		dataSource.setUsername("ssafy");
		dataSource.setPassword("ssafy");
		
		return dataSource;
	}
}
