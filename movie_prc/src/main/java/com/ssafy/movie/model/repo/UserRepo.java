package com.ssafy.movie.model.repo;

import org.springframework.stereotype.Repository;

import com.ssafy.movie.model.dto.User;

public interface UserRepo {
	
	User select(String id) throws Exception;

}
