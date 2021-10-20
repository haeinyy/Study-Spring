package com.ssafy.di.calc;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ssafy.di.log.Log;

@Service("calc")
public class CalcImpl implements Calc {
	
//	@Resource(name="mylog")
//	@Inject
	
	// 이것만 기억하기 !!!!! 제일 많이씀!!!!!!!
	// 시험!!
	@Autowired
//	@Qualifier("dblog")
	@Qualifier("mylog")
	private Log log;
	
	// 생성자 1
//	public CalcImpl() {
//		System.out.println("CalcImpl()");
//	}
	// 생성자 2
	// 생성자를 실행을 시켜서 값을 대입 시킬려고 함 
//	@Autowired
//	@Qualifier("mylog") => 에러 
//	public CalcImpl(@Qualifier("mylog") Log log) {
//	public CalcImpl(Log log) {
//		System.out.println("CalcImpl(Log log)");
//		this.log=log;
//	}
	
	// getter/setter => property
//	public Log getAbLog() {
//		System.out.println("CalcImpl.getLog()");
//		return log;
//	}
//	public void setLog(Log log) {
//		System.out.println("CalcImpl.setLog(Log log)");
//		this.log = log;
//	}
//	public Log getAbcLog() {
//		System.out.println("CalcImpl.getAbcLog()");
//		return log;
//	}
//	public void setAbcLog(Log log) {
//		System.out.println("CalcImpl.setAbcLog(Log log)");
//		this.log = log;
//	}
	
	@Override
	public int plus(int x, int y) {
		// log는 객체 생성 안해서 null point떨어짐 
		log.info("CalcImpl.plus(int "+x+", int "+y+")");
		return x+y;
	}

	@Override
	public int minus(int x, int y) {
		log.info("CalcImpl.minus(int "+x+", int "+y+")");
		return x-y;
	}

}
