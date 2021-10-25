package com.ssafy.phone.model.dao;

import com.ssafy.phone.model.dto.*;

public interface UserDAO {

	User select(String id) throws Exception;
}
