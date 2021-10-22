package com.ssafy.hw2.service; 

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.hw2.dao.GoodsDAO;
import com.ssafy.hw2.model.*;

@Service
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	private GoodsDAO goodsDAO;
	
	public GoodsServiceImpl() {};
	
	
	public GoodsDAO getGoodsDAO() {
		return goodsDAO;
	}

	public void setGoodsDAO(GoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}


	@Override
	public List<ItemVO> list(Map itemMap) {
		return goodsDAO.list(itemMap);
	}

	@Override
	public List<CateVO> listCate(Map cateMap) {
		return goodsDAO.listCate(cateMap);
	}

	@Override
	public String insert(Map product) {
		return null;
	}

	@Override
	public Boolean modify(Map product) {
		return null;
	}
	
	
 
}
