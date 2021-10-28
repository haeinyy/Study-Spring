package com.ssafy.mvc;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.Log4jLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.mvc.model.repo.EmpRepo;
import com.ssafy.mvc.model.service.EmpService;

public class Test1_BeanCreation extends AbstractTest{
	
	private static final Logger logger = LoggerFactory.getLogger(Test1_BeanCreation.class);
	
	@Autowired
	DataSource ds;
	
	@Autowired
	EmpRepo empRepo;
	
	@Autowired
	EmpService empService;
	
	@Test
	public void testDataSource() {
		logger.debug("datasource 확인 : {}", ds);
		assertNotNull(ds); // null 아닐때 실행 
	}
	
	@Test
	public void testBeanCreation() {
		assertNotNull(empRepo); // null 아닐때 실행 
		assertNotNull(empService); // null 아닐때 실행 
	}
}
