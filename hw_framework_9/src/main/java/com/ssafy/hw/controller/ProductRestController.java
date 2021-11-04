package com.ssafy.hw.controller;

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

import com.ssafy.hw.dto.Product;
import com.ssafy.hw.dto.SearchCondition;
import com.ssafy.hw.model.service.ProductService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@RequestMapping("/productapi")
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	private ResponseEntity<?> exceptionHandling(Exception e){
		e.printStackTrace(); // 무조건 해주기
		return new ResponseEntity<String>("Exception : "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); //500
	}
	
	@PostMapping("/product")
	@ApiOperation(value = "Product 객체를 등록합니다", response=Integer.class)
	public ResponseEntity<?> insert(@RequestBody Product product) {
		try {
			int result = productService.insert(product);
			return new ResponseEntity<Integer>(result,HttpStatus.CREATED); // 201
		} catch(Exception e){
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/product/{item_code}")
	@ApiOperation(value="{item_code}에 해당하는 Product 정보를 반환합니다.",response = Product.class)
	public ResponseEntity<?> select(@PathVariable String item_code){
		try {
			Product product = productService.select(item_code);
			if(product!=null)
				return new ResponseEntity<Product>(product,HttpStatus.OK); // 200
			else
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); //204
		} catch (Exception e){
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/product")
	@ApiOperation(value="query string에 해당하는 검색 조건에 해당하는 상품 목록을 반환합니다.",response = Product.class)
	public ResponseEntity<?> search(SearchCondition condition){
		try {
			List<Product> products = productService.search(condition);
			if(products!=null && products.size()>0)
				return new ResponseEntity<List<Product>>(products,HttpStatus.OK);//200
			else                              
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);//204
			
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@PutMapping("/product")
	@ApiOperation(value = "Book 객체를 수정합니다.", response = Integer.class)
	public ResponseEntity<?> update(@RequestBody Product product) {
		try {
			int result = productService.update(product);
			if(result==1) 
				return new ResponseEntity<Integer>(result,HttpStatus.CREATED);//201
			else          
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);//204
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@DeleteMapping("/product/{item_code}")
	@ApiOperation(value = "{item_code}에 해당하는 Book 객체를 삭제합니다.", response = Integer.class)
	public ResponseEntity<?> delete(@PathVariable String item_code) {
		try {
			int result=productService.delete(item_code);
			if(result==1) 
				return new ResponseEntity<Integer>(result,HttpStatus.CREATED);//201
			else          
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);//204
		} catch (Exception e){
			return exceptionHandling(e);
		}
	}
 }
