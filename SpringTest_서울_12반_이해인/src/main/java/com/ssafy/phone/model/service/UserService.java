package com.ssafy.phone.model.service;

import com.ssafy.phone.model.dto.User;

public interface UserService {
	
	User select(String id) throws Exception;
}
