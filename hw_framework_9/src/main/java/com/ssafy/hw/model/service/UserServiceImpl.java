package com.ssafy.hw.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssafy.hw.dto.User;
import com.ssafy.hw.model.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User select(String id) {
		return userRepo.select(id);
	}

}
