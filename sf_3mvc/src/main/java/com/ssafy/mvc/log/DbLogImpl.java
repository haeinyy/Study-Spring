package com.ssafy.mvc.log;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component("dblog")
@Repository("dblog")
public class DbLogImpl implements Log {

	@Override
	public void info(String log) {
		System.out.println("DB Log : "+log);
	}

}
