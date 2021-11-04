package com.ssafy.hw.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.hw.dto.Product;
import com.ssafy.hw.dto.SearchCondition;

public interface ProductService {
	
	int insert(Product product);
	int update(Product product);
	int delete(String item_code);
	Product select(String item_code);
	List<Product> search(SearchCondition condition);
	Map<String, Object> pagingSearch(SearchCondition condition);

}
