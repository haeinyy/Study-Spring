package com.ssafy.hw2.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.hw2.model.*;

public class GoodsDAOImpl implements GoodsDAO {
	
	List<ItemVO> list(Map<String, Object> param);
	List<CateVO> listCate(Map<String, Object>);
	int insert(Map<String, Object> );
	int modify(Map<String, Object>);
	
}
