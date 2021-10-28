package com.ssafy.ws;

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

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.dto.User;
import com.ssafy.ws.model.repo.BookRepo;
import com.ssafy.ws.model.repo.UserRepo;

public class WS_05_RepoTest extends AbstractTest {
	private static final Logger logger=LoggerFactory.getLogger(WS_05_RepoTest.class);
	
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
	BookRepo brepo;

	@Test
	public void testSelectUser() {
		User user=urepo.select("ssafy");
		assertEquals(user.getName(), "김싸피");
	}

	@Test
	public void testSelectBook() {
		Book book=brepo.select("111-000-0001");
		assertEquals(book.getTitle(), "도서명 11");
		assertEquals(book.getPrice(), 1500);
	}	
	@Test
	public void testSearchBook() {
		List<Book> books=brepo.search();
		assertEquals(books.size(), 20);
		assertEquals(books.get(0).getTitle(), "도서명 11");
	}
	
	@Test
	@Transactional
	public void testInsertBook() {
		Book book=new Book("isbn", "title", "author", 100, "content", "img");
		assertEquals(brepo.insert(book), 1);
		
		Book selected=brepo.select("isbn");
		assertEquals(book.getTitle(), selected.getTitle());
		assertEquals(book.getPrice(), selected.getPrice());
	}
	
	@Test
	@Transactional
	public void testUpdateBook() {
		//Book book=new Book("111-000-0001", "도서명 11", "삼무국", 1500, "도서 내용 11", "표지경로 11");
		Book book=new Book("111-000-0001", "제목", "삼무국", 1515, "도서 내용 11", "표지경로 11");
		assertEquals(brepo.update(book), 1);

		Book selected=brepo.select("111-000-0001");
		assertEquals(selected.getTitle(), "제목");
		assertEquals(selected.getPrice(), 1515);
	}
	
	@Test
	@Transactional
	public void testDeleteBook() {
		Book book=brepo.select("111-000-0001");
		assertNotNull(book);

		assertEquals(brepo.delete("111-000-0001"), 1);
		book=brepo.select("111-000-0001");
		assertNull(book);
	}	
}
