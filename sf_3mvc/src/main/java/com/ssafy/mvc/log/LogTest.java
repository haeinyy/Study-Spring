package com.ssafy.mvc.log;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class LogTest {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		
		Log bean = (Log) context.getBean("mylog");
//		Log bean = (Log) context.getBean("dblog");
//		Log bean = context.getBean(Log.class); // 2개이상 impl했을때 유니크하지 않아서 에러 떨어짐 
//		Log bean = context.getBean(MyLogImpl.class); // 에러안남!
		bean.info("메세지를 출력합니다!");
	}

}
