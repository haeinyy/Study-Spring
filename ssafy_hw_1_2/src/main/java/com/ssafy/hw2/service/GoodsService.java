package com.ssafy.hw2.service; 

import java.util.List;
import java.util.Map;

import com.ssafy.hw2.model.*;


public interface GoodsService {
  
	List<ItemVO> list(Map itemMap);
	List<CateVO> listCate(Map cateMap);
	String insert(Map product);
	Boolean modify(Map product);

}
