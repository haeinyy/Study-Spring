package com.ssafy.hw2.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ssafy.hw2.dao.GoodsDAO;
import com.ssafy.hw2.service.GoodsService;

public class BeanTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
	
		GoodsDAO gdao = (GoodsDAO) context.getBean("goodsDAOImpl");
		System.out.println(gdao);
		
		GoodsService gserv = (GoodsService) context.getBean("goodsServiceImpl");
		System.out.println(gserv);
	}

}
