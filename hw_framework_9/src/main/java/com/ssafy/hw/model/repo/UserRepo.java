package com.ssafy.hw.model.repo;

import com.ssafy.hw.dto.User;

public interface UserRepo {
	
	User select(String id);

}
