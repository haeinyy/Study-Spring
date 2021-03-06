package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.dto.SearchCondition;
import com.ssafy.ws.model.repo.BookRepo;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepo repo;
	
	public BookRepo getBookRepo() {
		return repo;
	}
	public void setBookRepo(BookRepo repo) {
		this.repo = repo;
	}
	
	@Override
	@Transactional
	public int insert(Book book) {
		return repo.insert(book);
	}
	@Override
	@Transactional
	public int update(Book book) {
		return repo.update(book);
	}
	@Override
	@Transactional
	public int delete(String isbn) {
		return repo.delete(isbn);
	}
	@Override
	public Book select(String isbn) {
		return repo.select(isbn);
	}
	@Override
	public 	List<Book> search(SearchCondition condition) {
		return repo.search(condition);
	}
}
