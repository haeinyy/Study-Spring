package com.ssafy.mvc.calc;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ssafy.mvc.log.Log;

@Service("calc")
public class CalcImpl implements Calc {

	// 이것만 기억하기 !!!!! 제일 많이씀!!!!!!!
	// 시험!!
	@Autowired
//	@Qualifier("dblog")
	@Qualifier("mylog")
	private Log log;
	
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
