package com.ssafy.movie.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.moive.model.dto.User;
import com.ssafy.movie.model.repo.UserRepo;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo repo;
	
	@Override
	public User select(String id) throws SQLException {
		return repo.select(id);
	}

}
