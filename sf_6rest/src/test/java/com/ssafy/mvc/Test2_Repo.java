package com.ssafy.mvc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.Log4jLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.mvc.model.dto.Emp;
import com.ssafy.mvc.model.repo.EmpRepo;
import com.ssafy.mvc.model.service.EmpService;

public class Test2_Repo extends AbstractTest{
	
	private static final Logger logger = LoggerFactory.getLogger(Test2_Repo.class);
	
	@Autowired
	DataSource ds;
	
	@Autowired
	SqlSessionFactory factory;
	
	@Autowired
	EmpRepo empRepo;
	
	@Test
	public void testMyBatis() {
		assertNotNull(ds);
		assertNotNull(factory);
		assertNotNull(empRepo);
	}
	
	@Test
	@Transactional
//	@Rollback(false)
	public void testInsert() {
		Emp emp = new Emp(107,"홍길동", 7000);
		assertEquals(empRepo.insert(emp),1);
		
		Emp selected = empRepo.select(106);
		assertEquals(emp.getName(), selected.getName());
		assertEquals(emp.getSalary(), selected.getSalary());
	}
	
	@Test
	public void testSearch() {
		List<Emp> emps = empRepo.search();
		assertEquals(emps.size(),5);
		assertEquals(emps.get(0).getName(),"홍길동");
	}
	
	@Test
	public void testSelect() {
		Emp emp = empRepo.select(101);
		assertEquals(emp.getName(),"홍길동");
		assertEquals(emp.getSalary(), 1000);
	}
	
	@Test
	@Transactional
	public void testDelete() {
		Emp emp = empRepo.select(101);
		assertNotNull(emp);
		
		assertEquals(empRepo.delete(101),1);
		Emp selected = empRepo.select(101);
		assertNull(selected);
	}
	
	@Test
	public void testUpdate() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("salary", 1111);
		map.put("num", 101);
		assertEquals(empRepo.update(map), 1);
		
		Emp selected = empRepo.select(101);
		assertEquals(selected.getSalary(),1111);
	}
}
