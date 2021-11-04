package com.ssafy.hw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.hw.model.repo.ProductRepo;
import com.ssafy.hw.model.repo.UserRepo;
import com.ssafy.hw.model.service.ProductService;
import com.ssafy.hw.model.service.UserService;
import com.ssafy.hw.dto.Product;
import com.ssafy.hw.dto.SearchCondition;
import com.ssafy.hw.dto.User;

public class HW_06_ServiceTest extends AbstractTest {
	
	private static final Logger logger=LoggerFactory.getLogger(HW_05_RepoTest.class);
	
	@Autowired
	UserService us;
	@Autowired
	ProductService ps;

	@Test
	public void testSelectUser() {
		User user=us.select("ssafy");
		assertEquals(user.getName(), "김싸피");
	}
	
	@Test
	public void testSearch() {
		List<Product> products = ps.search(new SearchCondition());
		assertEquals(products.size(), 1);
		assertEquals(products.get(0).getItem_name(), "냉장고");
	}
	
	@Test
	@Transactional
	public void testInsertBook() {
		Product product = new Product(2, "item_code", "item_name", 20, "item_corp", "img");
//		System.out.println(prepo.insert(product));
		assertEquals(ps.insert(product), 1);

		Product selected = ps.select("item_code");
		assertEquals(product.getItem_name(), selected.getItem_name());
		assertEquals(product.getItem_price(), selected.getItem_price());
	}
	
	@Test
	@Transactional
	public void testUpdateBook() {
		Product product = new Product(1, "22222", "티비", 10000000, "2", "img");
		assertEquals(ps.update(product), 1);
		Product selected = ps.select("item_code");
		assertEquals(selected.getItem_name(), "티비");
	}
	
	@Test
	@Transactional
	public void testDeleteBook() {
		Product product=ps.select("22222");
		assertNotNull(product);
		
		assertEquals(ps.delete("22222"), 1);
		product = ps.select("22222");
		assertNull(product);
	}
}
