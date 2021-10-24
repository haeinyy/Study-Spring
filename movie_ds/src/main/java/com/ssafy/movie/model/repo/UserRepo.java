package com.ssafy.movie.model.repo;

import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.ssafy.moive.model.dto.User;

public interface UserRepo {
	User select(String id) throws SQLException;
	
	
}
