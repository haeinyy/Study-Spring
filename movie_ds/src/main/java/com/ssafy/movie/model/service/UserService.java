package com.ssafy.movie.model.service;

import java.sql.SQLException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ssafy.moive.model.dto.User;

public interface UserService {
	User select(String id) throws SQLException;
	
	
}
