package com.ssafy.di.calc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalcTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("ApplicationContext.xml");
		Calc bean = (Calc) context.getBean("calc");
//		Calc bean = context.getBean(CalcImpl.class); // xml파일 bean에 id없어도 실행가능! 왜? 하나만 impl 했기때문 
		System.out.println(bean.plus(22, 11));
//		System.out.println(bean.minus(22, 11));

	}

}
