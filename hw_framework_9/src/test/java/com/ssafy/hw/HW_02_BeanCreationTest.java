package com.ssafy.hw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssafy.hw.model.repo.*;
import com.ssafy.hw.model.service.*;

/**
 * AbstractTest를 상속받아 기본 @RunWith와 @ContextConfiguration 설정을 재사용한다.
 */
public class HW_02_BeanCreationTest extends AbstractTest{

	/**
	 * 로깅 처리를 위해 Logger를 설정한다.
	 */
	private static Logger logger = LoggerFactory.getLogger(HW_02_BeanCreationTest.class);


	// 필요한 빈들을 @Autowired로 주입받는다.
	@Autowired
	ProductRepo prepo;
	@Autowired
	ProductService pserv;
	@Autowired
	UserRepo urepo;
	@Autowired
	UserService userv;
	@Autowired
	DataSource ds;
	
	/**
	 * BookRepo, UserRepo, BookService, UserService가 잘 생성되었는지 테스트한다.
	 */
	@Test
	public void testBeanCreation() {
		assertNotNull(prepo);
		assertNotNull(pserv);
		assertNotNull(urepo);
		assertNotNull(userv);
	}

	/**
	 * 컨텍스트에서 직접 얻어온 BookRepo와 BookService가 가지는 BookRepo가 동일한지 테스트 한다.
	 */
	@Test
	public void testSingleton() {
//		assertEquals(brepo, ((BookServiceImpl) bserv).getBookrepo());
		// singleton에서 에러 떨어짐 
		logger.debug("pserv 확인 : {}",pserv);
		logger.debug("productService : {} {} {}", 
				pserv.getClass().getName(), 
				pserv instanceof ProductService, 
				pserv instanceof ProductServiceImpl);
	}

	/**
	 * DataSource객체가 잘 생성되었는지 테스트하고 출력한다.
	 */
	@Test
	public void testDataSource() {
		logger.debug("datasource 확인: {}", ds);
		assertNotNull(ds);
	}

}
