package com.ssafy.phone.model.service;

import java.util.List;

import com.ssafy.phone.model.dto.Phone;

public interface IPhoneService {
	
	int insert(Phone p) throws Exception;
	List<Phone> search() throws Exception;
	Phone select(String num) throws Exception;
	int delete(String num) throws Exception;

}
