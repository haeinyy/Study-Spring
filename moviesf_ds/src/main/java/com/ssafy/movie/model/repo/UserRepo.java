package com.ssafy.movie.model.repo;

import java.sql.SQLException;
import com.ssafy.movie.model.dto.User;

public interface UserRepo {
	
	User select(String id) throws SQLException;

}
