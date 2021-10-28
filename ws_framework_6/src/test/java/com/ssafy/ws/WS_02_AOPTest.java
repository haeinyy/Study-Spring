package com.ssafy.ws;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.ws.model.service.BookService;

public class WS_02_AOPTest extends AbstractTest{
	private static Logger logger = LoggerFactory.getLogger(WS_02_AOPTest.class);

	@Autowired
	BookService bserv;

	@Test
	public void testBeanCreation() {
		bserv.insert(null);
		bserv.select("111-222-3333");
//		bserv.search();
	}
}
