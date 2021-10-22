package com.ssafy.hw2.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.hw2.model.*;

public interface GoodsDAO {
 
	List<ItemVO> list(Map itemMap);
	List<CateVO> listCate(Map cateMap);
	int insert(Map product);
	int modify(Map product);
}
