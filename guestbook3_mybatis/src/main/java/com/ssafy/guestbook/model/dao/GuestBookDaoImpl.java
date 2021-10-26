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
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			sqlSession.insert(NAMESPACE+"registerArticle", guestBookDto);
			List<FileInfoDto> fileInfos = guestBookDto.getFileInfos();
			if(fileInfos != null && !fileInfos.isEmpty()) { // 파일 업로드를 했다
				sqlSession.insert(NAMESPACE+"reigsterFile", guestBookDto);
			}
			sqlSession.commit();
		}
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
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			return sqlSession.selectOne(NAMESPACE+"getArticle", articleNo);
		}
	}

	@Override
	public void updateArticle(GuestBookDto guestBookDto) throws Exception {
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			sqlSession.selectOne(NAMESPACE+"updateArticle", guestBookDto);
			sqlSession.commit();
		}
	}

	@Override
	public void deleteArticle(int articleNo) throws Exception {
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			sqlSession.selectOne(NAMESPACE+"deleteFile", articleNo);
			sqlSession.selectOne(NAMESPACE+"deleteArticle", articleNo);
			sqlSession.commit();
		}
	}

	@Override
	public List<FileInfoDto> fileInfoList(int articleNo) throws Exception {
		try (SqlSession sqlSession = SqlMapConfig.getSqlSession()) {
			return sqlSession.selectList(NAMESPACE+"fileInfoList", articleNo);
		}
	}

}
