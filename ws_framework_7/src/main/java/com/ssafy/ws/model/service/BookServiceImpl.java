package com.ssafy.ws.model.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.dto.SearchCondition;
import com.ssafy.ws.model.repo.BookRepo;
import com.ssafy.ws.util.PageNavigation;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	ResourceLoader loader;
	
	@Autowired
	private BookRepo repo;
	
	public BookRepo getBookRepo() {
		return repo;
	}
	public void setBookRepo(BookRepo repo) {
		this.repo = repo;
	}
	
	public void fileHandling(Book book) throws IllegalStateException, IOException {
		MultipartFile file = book.getFile();
		if(file!=null && file.getSize()>0) {
			Resource res=loader.getResource("resources/upload");
			book.setImg(System.currentTimeMillis()+"_"+file.getOriginalFilename());
			book.setOrgImg(file.getOriginalFilename());
			file.transferTo(new File(res.getFile().getCanonicalPath()+"/"+book.getImg()));
		}
	}
	
	@Override
	@Transactional
	public int insert(Book book) throws IllegalStateException, IOException {
		fileHandling(book);
		return repo.insert(book);
	}
	
	@Override
	@Transactional
	public int update(Book book) throws IllegalStateException, IOException {
		fileHandling(book);
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
	
	@Override
	public Map<String, Object> pagingSearch(SearchCondition condition) {
		int totalCount = repo.getTotalSearchCount(condition);
		PageNavigation nav = new PageNavigation(condition.getCountPerPage(), totalCount);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("books", repo.search(condition));
		map.put("navigation", nav);
		return map;
	}
}
