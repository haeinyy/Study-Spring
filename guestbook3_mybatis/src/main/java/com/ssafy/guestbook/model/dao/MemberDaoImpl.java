package com.ssafy.guestbook.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.util.SqlMapConfig;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	private final String NAMESPACE = "com.ssafy.guestbook.model.dao.MemberDao."; // . 주의!!!

	@Override
	public int idCheck(String id) throws Exception {
		return 0;
	}

	@Override
	public void registerMember(MemberDto memberDto) throws Exception {
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			sqlSession.insert(NAMESPACE+ "registerMember", memberDto); // 회원가입위해서는 memberDto필요해
			sqlSession.commit();
		}
	}

	@Override
	public MemberDto login(Map<String, String> map) throws Exception {
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			return sqlSession.selectOne(NAMESPACE+ "login", map); // 회원가입위해서는 memberDto필요해
		}
	}

}
