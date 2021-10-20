package com.ssafy.di.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	@Before("execution(* *..plus(..))")
	public void before(JoinPoint jp) {
		System.out.println("실행전 : before()");
		Object[] args = jp.getArgs();
		System.out.println("인자수 : "+args.length);
		System.out.println(Arrays.deepToString(args));
		String ll = jp.getSignature().toLongString();
		System.out.println("롱인자: "+ll);
		String ss=jp.getSignature().toShortString();
		System.out.println("숏인자 : "+ss);
	}
	
	@After("execution(* *..plus(..))")
	public void after(JoinPoint jp) {
		System.out.println("실행후 : after()");
	}
	
	@AfterReturning(value="execution(* *..plus(..))",returning="re")
	public void afterReturning(JoinPoint jp, Object re) {
		String name=jp.getSignature().getName();
		System.out.println("실행후정 : after() "+name+", "+re);
	}
	
	@AfterThrowing(value="execution(* *..plus(..))",throwing="ex")
	public void afterThrowing(JoinPoint jp, Throwable ex) {
		String name=jp.getSignature().getName();
		System.out.println("실행후정 : after() "+name+", "+ex.getMessage());
	}
	
	@Around("execution(* *..plus(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("실행전전 : around()"+ Arrays.deepToString(pjp.getArgs()));
		Object obj = pjp.proceed();
		System.out.println("실행후후 : around()");
		return obj;
	}
}
