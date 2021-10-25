package com.ssafy.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	
	private static SqlSessionFactory factory;
	
	// 클래스로더에 의해 읽혀질때 
	static {
		try {
			String resource = "mybatis-config.xml";  // 읽어드림
			Reader reader;
			reader = Resources.getResourceAsReader(resource);
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public static SqlSession getSqlSession() {
		return factory.openSession();
	}
	
}
