package com.ssafy.di.log;

public class MyLogImpl implements Log {

	@Override
	public void info(String log) {	
		System.out.println("My Log : "+log);
	}

}
