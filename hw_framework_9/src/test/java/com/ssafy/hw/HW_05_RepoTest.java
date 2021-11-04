package com.ssafy.hw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.hw.dto.*;
import com.ssafy.hw.model.repo.UserRepo;
import com.ssafy.hw.model.repo.ProductRepo;
import com.ssafy.hw.AbstractTest;

public class HW_05_RepoTest extends AbstractTest {
	
	private static final Logger logger=LoggerFactory.getLogger(HW_05_RepoTest.class);
	
	@Autowired
	DataSource ds;
	
	@Autowired
	SqlSessionFactory factory;
	
	@Test
	public void testMyBatisSet() {
		assertNotNull(ds);
		assertNotNull(factory);
	}
	
	@Autowired
	UserRepo urepo;
	@Autowired
	ProductRepo prepo;
	
	@Test
	public void testSelectUser() {
		User user=urepo.select("ssafy");
		assertEquals(user.getName(), "김싸피");
	}
	
	@Test
	public void testSelectProduct() {
		Product product=prepo.select("22222");
		assertEquals(product.getItem_name(), "냉장고");
		assertEquals(product.getItem_corp(), "1");
	}	
	
	@Test
	public void testSearchProduct() {
		List<Product> products = prepo.search(new SearchCondition());
		assertEquals(products.size(), 1);
		assertEquals(products.get(0).getItem_name(), "냉장고");
	}
	
	@Test
	@Transactional
	public void testInsertProduct() {
		Product product = new Product(2, "item_code", "item_name", 20, "item_corp", "img");
//		System.out.println(prepo.insert(product));
		assertEquals(prepo.insert(product), 1);

		Product selected = prepo.select("item_code");
		assertEquals(product.getItem_name(), selected.getItem_name());
		assertEquals(product.getItem_price(), selected.getItem_price());
	}
	
	@Test
	@Transactional
	public void testUpdateProduct() {
		Product product = new Product(1, "22222", "티비", 10000000, "2", "img");
		assertEquals(prepo.update(product), 1);
		Product selected = prepo.select("item_code");
		assertEquals(selected.getItem_name(), "티비");
//		assertEquals(product.getItem_price(), selected.getItem_price());
	}
	
	@Test
	@Transactional
	public void testDeleteBook() {
		Product product=prepo.select("22222");
		assertNotNull(product);
		
		assertEquals(prepo.delete("22222"), 1);
		product = prepo.select("22222");
		assertNull(product);
	}
}
