package com.ssafy.mvc.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.mvc.model.dto.Emp;

public interface EmpService {
	
	int insert(Emp emp);
	List<Emp> search();
	Emp select(int num);
	int delete(int num);
	int update(Map<String, Integer> map); // salary만 변경가능 
	

}
