package com.ssafy.ws;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.dto.SearchCondition;
import com.ssafy.ws.model.repo.BookRepo;

public class WS_06_DynamicQueryTest extends AbstractTest{
	private static final Logger logger=LoggerFactory.getLogger(WS_06_DynamicQueryTest.class);
	
	@Autowired
	BookRepo brepo;
	
	@Test
	public void testByNone() {
		SearchCondition condition=new SearchCondition();
		condition.setLimit(false);
		List<Book> selected=brepo.search(condition);
		assertEquals(selected.size(), 20);
		
		condition.setLimit(true);
		selected=brepo.search(condition);
		assertEquals(selected.size(), 10);
	}	

	@Test
	public void testByAuthor(){
		SearchCondition condition=new SearchCondition("author","일무국");//key,word
		List<Book> selected=brepo.search(condition);
		assertEquals(selected.size(), 5);
	}
	
	@Test
	public void testByTitle() {
		SearchCondition condition=new SearchCondition("title","싸피","isbn","desc");//key,word,orderBy,orderByDir
		List<Book> selected=brepo.search(condition);
		
		assertEquals(selected.size(), 10);
		assertEquals(selected.get(0).getIsbn(), "111-222-9999");
	}
	
	@Test
	public void testByContent() {
		SearchCondition condition=new SearchCondition("content"," ","isbn","desc", 1);//key,word,orderBy,orderByDir,currentPage
		List<Book> selected=brepo.search(condition);
		assertEquals(selected.get(0).getIsbn(), "111-222-9999");
		assertEquals(selected.size(), 10);
	}
}
