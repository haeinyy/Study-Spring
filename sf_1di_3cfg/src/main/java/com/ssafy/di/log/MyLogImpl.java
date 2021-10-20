package com.ssafy.di.log;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component("mylog")
@Repository("mylog")
public class MyLogImpl implements Log {

	@Override
	public void info(String log) {	
		System.out.println("My Log : "+log);
	}

}
