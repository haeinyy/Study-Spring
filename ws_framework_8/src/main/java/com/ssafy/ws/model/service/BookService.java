package com.ssafy.ws.model.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.dto.SearchCondition;

public interface BookService {
	int insert(Book book) throws IllegalStateException, IOException ;
	int update(Book book) throws IllegalStateException, IOException ;
	int delete(String isbn);
	Book select(String isbn);
	List<Book> search(SearchCondition condition);
	Map<String, Object> pagingSearch(SearchCondition condition);
}
