package com.ssafy.phone.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.phone.model.dao.UserDAO;
import com.ssafy.phone.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public User select(String id) throws Exception {
		return userDAO.select(id);
	}

}
