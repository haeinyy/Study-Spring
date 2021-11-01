package com.ssafy.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.dto.SearchCondition;
import com.ssafy.ws.model.service.BookService;
import io.swagger.annotations.ApiOperation;


@RestController // retunr이 될때 모든 것이 ResponseBody로 리턴됨(데이터)
@CrossOrigin("*")
@RequestMapping("/bookapi")
public class BookRestController {

	@Autowired
	private BookService bookService;
	
	private ResponseEntity<?> exceptionHandling(Exception e){
		e.printStackTrace(); // 무조건 해주기
		return new ResponseEntity<String>("Exception : "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); //500
	}
	
	@PostMapping("/book")
	@ApiOperation(value = "Book 객체를 등록합니다", response=Integer.class)
	public ResponseEntity<?> insert(@RequestBody Book book) {
		try {
			int result = bookService.insert(book);
			return new ResponseEntity<Integer>(result,HttpStatus.CREATED); // 201
		} catch(Exception e){
			return exceptionHandling(e);
		}
	}
	
	@PutMapping("/book")
	@ApiOperation(value = "Book 객체를 수정합니다.", response = Integer.class)
	public ResponseEntity<?> update(@RequestBody Book book) {
		try {
			int result=bookService.update(book);
			if(result==1) 
				return new ResponseEntity<Integer>(result,HttpStatus.CREATED);//201
			else          
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);//204
		}catch(Exception e) {
			return exceptionHandling(e);
		}
	}

	@DeleteMapping("/book/{isbn}")
	@ApiOperation(value = "{isbn}에 해당하는 Book 객체를 삭제합니다.", response = Integer.class)
	public ResponseEntity<?> delete(@PathVariable String isbn) {
		try {
			int result=bookService.delete(isbn);
			if(result==1) 
				return new ResponseEntity<Integer>(result,HttpStatus.CREATED);//201
			else          
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);//204
		}catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/book/{isbn}")
	@ApiOperation(value = "{isbn}에 해당하는 Book 정보를 반환합니다.", response = Book.class)
	public ResponseEntity<?> select(@PathVariable String isbn) {
		try {
			Book book=bookService.select(isbn);
			if(book!=null) 
				return new ResponseEntity<Book>(book,HttpStatus.OK);//200
			else           
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);//204
		}catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	@GetMapping("/book")
	@ApiOperation(value = "query string에 해당하는 검색 조건에 해당하는 도서 목록을 반환합니다.", response = Book.class)	
	public ResponseEntity<?> search(SearchCondition condition){
		try {
			List<Book> books=bookService.search(condition);
			if(books!=null && books.size()>0) 
				return new ResponseEntity<List<Book>>(books,HttpStatus.OK);//200
			else                              
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);//204
		}catch(Exception e) {
			return exceptionHandling(e);
		}
	}
}
