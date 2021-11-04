package com.ssafy.hw;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.hw.dto.Product;
import com.ssafy.hw.dto.SearchCondition;
import com.ssafy.hw.model.repo.ProductRepo;

public class HW_06_DynamicQueryTest  extends AbstractTest{

	private static final Logger logger=LoggerFactory.getLogger(HW_05_RepoTest.class);
	
	@Autowired
	ProductRepo prepo;
	
	@Test
	public void testByNone() {
		SearchCondition condition=new SearchCondition();
		condition.setLimit(false);
		List<Product> selected=prepo.search(condition);
		assertEquals(selected.size(), 1);
		
		condition.setLimit(true);
		selected=prepo.search(condition);
		assertEquals(selected.size(), 1);
	}	
	
	@Test
	public void testByItemName(){
		SearchCondition condition=new SearchCondition("item_name", "냉장고");
		List<Product> selected=prepo.search(condition);
		assertEquals(selected.size(), 1);
	}
	
	@Test
	public void testByItemCorp() {
		SearchCondition condition=new SearchCondition("item_corp", "1", "item_code", "desc");
		List<Product> selected=prepo.search(condition);
		assertEquals(selected.size(), 1);
		assertEquals(selected.get(0).getItem_corp(), "1");
	}

}
