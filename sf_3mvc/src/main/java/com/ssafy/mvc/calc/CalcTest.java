package com.ssafy.mvc.calc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalcTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		Calc bean = (Calc) context.getBean("calc");
		System.out.println(bean.plus(22, 11));
//		System.out.println(bean.minus(22, 11));

	}

}
