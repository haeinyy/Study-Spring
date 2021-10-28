package com.ssafy.mvc.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.mvc.model.dto.Emp;
import com.ssafy.mvc.model.repo.EmpRepo;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpRepo empRepo;

	@Override
	@Transactional
	public int insert(Emp emp) {
		return empRepo.insert(emp);
	}

	@Override
	public List<Emp> search() {
		return empRepo.search();
	}

	@Override
	public Emp select(int num) {
		return empRepo.select(num);
	}

	@Override
	@Transactional
	public int delete(int num) {
		return empRepo.delete(num);
	}

	@Override
	@Transactional
	public int update(Map<String, Integer> map) {
		return empRepo.update(map);
	}

}
