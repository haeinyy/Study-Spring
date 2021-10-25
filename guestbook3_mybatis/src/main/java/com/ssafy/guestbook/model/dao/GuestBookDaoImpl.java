package com.ssafy.guestbook.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ssafy.guestbook.model.FileInfoDto;
import com.ssafy.guestbook.model.GuestBookDto;
import com.ssafy.util.SqlMapConfig;

@Repository
public class GuestBookDaoImpl implements GuestBookDao {
	
	private final String NAMESPACE = "com.ssafy.guestbook.model.dao.GuestBookDao."; // . 주의!!!

	@Override
	public void registerArticle(GuestBookDto guestBookDto) throws Exception {

	}

	@Override
	public List<GuestBookDto> listArticle(Map<String, Object> map) throws Exception {
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			return sqlSession.selectList(NAMESPACE+"listArticle", map);
		}
	}

	@Override
	public int getTotalCount(Map<String, String> map) throws Exception {
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			return sqlSession.selectOne(NAMESPACE+"getTotalCount", map);
		}
	}

	@Override
	public GuestBookDto getArticle(int articleNo) throws Exception {
		return null;
	}

	@Override
	public void updateArticle(GuestBookDto guestBookDto) throws Exception {

	}

	@Override
	public void deleteArticle(int articleNo) throws Exception {

	}

	@Override
	public List<FileInfoDto> fileInfoList(int articleNo) throws Exception {
		return null;
	}

}
