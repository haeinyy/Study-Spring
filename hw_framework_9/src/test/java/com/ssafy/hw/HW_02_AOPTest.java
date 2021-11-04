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
public class HW_02_AOPTest extends AbstractTest{

	/**
	 * 로깅 처리를 위해 Logger를 설정한다.
	 */
	private static Logger logger = LoggerFactory.getLogger(HW_02_AOPTest.class);


	// 필요한 빈들을 @Autowired로 주입받는다.
	@Autowired
	ProductService pserv;

	
	@Test
	public void testDataSource() {
		pserv.insert(null);
		pserv.select("1");
//		pserv.search();
	}

}
