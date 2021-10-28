package com.ssafy.ws;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.dto.SearchCondition;
import com.ssafy.ws.dto.User;
import com.ssafy.ws.model.service.BookService;
import com.ssafy.ws.model.service.UserService;

public class WS_06_ServiceTest extends AbstractTest {
	private static final Logger logger=LoggerFactory.getLogger(WS_06_ServiceTest.class);

	@Autowired
	UserService uService;
	@Autowired
	BookService bService;
	
	@Test
	public void testSelectUser() {
		User user=uService.select("ssafy");
		assertEquals(user.getName(), "김싸피");
	}
	
	@Test
	public void testSelectBook() {
		Book book=bService.select("111-000-0001");
		assertEquals(book.getTitle(), "도서명 11");
		assertEquals(book.getPrice(), 1500);
	}
	@Test
	public void testSearch() {
		List<Book> books=bService.search(new SearchCondition());
		assertEquals(books.size(), 10);
		assertEquals(books.get(0).getTitle(), "도서명 11");
	}


	@Test
	@Transactional
	public void testInsertBook() throws IllegalStateException, IOException {
		Book book=new Book("isbn", "title", "author", 100, "content", "img");
		assertEquals(bService.insert(book), 1);
		
		Book selected = bService.select("isbn");
		assertEquals(book.getTitle(), selected.getTitle());
		assertEquals(book.getPrice(), selected.getPrice());
	}

	@Test
	@Transactional
	public void testUpdateBook() throws IllegalStateException, IOException {
		//Book book=new Book("111-000-0001", "도서명 11", "삼무국", 1500, "도서 내용 11", "표지경로 11");
		Book book=new Book("111-000-0001", "제목", "삼무국", 1515, "도서 내용 11", "표지경로 11");
		assertEquals(bService.update(book), 1);
		
		Book selected = bService.select("111-000-0001");
		assertEquals(selected.getTitle(), "제목");
		assertEquals(selected.getPrice(), 1515);
	}

	@Test
	@Transactional
	public void testDeleteBook() {
		Book book=bService.select("111-000-0001");
		assertNotNull(book);

		assertEquals(bService.delete("111-000-0001"), 1);
		book=bService.select("111-000-0001");
		assertNull(book);
	}
}
