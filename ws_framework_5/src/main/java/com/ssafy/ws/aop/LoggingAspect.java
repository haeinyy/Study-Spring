package com.ssafy.ws.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	private static final Logger logger=LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(* com.ssafy.ws.model..*.*(..))")
	public void logging(JoinPoint jp) {
		logger.debug("메소드선언부:{}, 전달파라미터:{}",jp.getSignature(),Arrays.toString(jp.getArgs()));
	}
}
