package com.ssafy.hw2.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.hw2.model.*;

@Repository
public class GoodsDAOImpl implements GoodsDAO {
	
	@Autowired
	private DataSource dataSource;

	public GoodsDAOImpl() {};
	
	@Override
	public List<ItemVO> list(Map itemMap) {
		return null;
	}

	@Override
	public List<CateVO> listCate(Map cateMap) {
		return null;
	}

	@Override
	public int insert(Map product) {
		return 0;
	}

	@Override
	public int modify(Map product) {
		return 0;
	}
	
	
	
}
