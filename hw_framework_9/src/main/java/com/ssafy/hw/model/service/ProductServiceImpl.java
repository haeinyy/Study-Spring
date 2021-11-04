package com.ssafy.hw.model.service;

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
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.hw.dto.Product;
import com.ssafy.hw.dto.SearchCondition;
import com.ssafy.hw.model.repo.ProductRepo;
import com.ssafy.hw.util.PageNavigation;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ResourceLoader loader;
	
	@Autowired
	private ProductRepo productRepo;
	
	
	public ProductRepo getProductRepo() {
		return productRepo;
	}

	public void setProductRepo(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}
	
	public void fileHandling(Product product) throws IllegalStateException, IOException {
		MultipartFile file = product.getFile();
		if(file!=null && file.getSize()>0) {
			Resource res=loader.getResource("resources/upload");
			product.setImg(System.currentTimeMillis()+"_"+file.getOriginalFilename());
			product.setOrgimg(file.getOriginalFilename());
			file.transferTo(new File(res.getFile().getCanonicalPath()+"/"+product.getImg()));
		}
	}

	@Override
	@Transactional
	public int insert(Product product) {
		return productRepo.insert(product);
	}

	@Override
	@Transactional
	public int update(Product product) {
		return productRepo.update(product);
	}

	@Override
	@Transactional
	public int delete(String item_code) {
		return productRepo.delete(item_code);
	}

	@Override
	public Product select(String item_code) {
		return productRepo.select(item_code);
	}

	@Override
	public List<Product> search(SearchCondition condition) {
		return productRepo.search(condition);
	}

	@Override
	public Map<String, Object> pagingSearch(SearchCondition condition) {
		int totalCount = productRepo.getTotalSearchCount(condition);
		PageNavigation nav = new PageNavigation(condition.getCountPerPage(), totalCount);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("products", productRepo.search(condition));
		map.put("navigation", nav);
		return map;
	}

}
