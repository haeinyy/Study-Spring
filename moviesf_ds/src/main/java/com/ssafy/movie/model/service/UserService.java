package com.ssafy.movie.model.service;

import java.sql.SQLException;
import com.ssafy.movie.model.dto.User;

public interface UserService {
	
	User select(String id) throws SQLException;

}
