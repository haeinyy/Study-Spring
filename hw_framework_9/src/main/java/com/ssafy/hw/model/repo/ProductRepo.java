package com.ssafy.hw.model.repo;

import java.util.List;

import com.ssafy.hw.dto.Product;
import com.ssafy.hw.dto.SearchCondition;

public interface ProductRepo {
	
	int insert(Product product);
	int update(Product product);
	int delete(String item_code);
	Product select(String item_code);
	List<Product> search(SearchCondition condition);
	int getTotalSearchCount(SearchCondition condition);
}
