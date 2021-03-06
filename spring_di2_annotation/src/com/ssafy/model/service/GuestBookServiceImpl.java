package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ssafy.model.GuestBookDto;
import com.ssafy.model.dao.GuestBookDao;

@Service(value = "gbService") // Service인데 이름을 설정해줘야함!
public class GuestBookServiceImpl implements GuestBookService {
	
	@Autowired
//	@Qualifier("aa") : 하나의 interface는 여러곳에서 imple 받으면 뭐를 가져와야하는지 표시해줘함
	// 이름을 안주면? 자동으로 클래스 명의 맨앞을 소문자로 해서 이름 설정함
	private GuestBookDao guestBookDao;

	@Override
	public void writeArticle(GuestBookDto guestBookDto) throws Exception {
		if(guestBookDto.getSubject() == null || guestBookDto.getContent() == null) {
			throw new Exception();
		}
		guestBookDao.writeArticle(guestBookDto);
	}

	@Override
	public List<GuestBookDto> listArticle(String key, String word) throws Exception {
		key = key == null ? "" : key;
		word = word == null ? "" : word;
		return guestBookDao.listArticle(key, word);
	}

	@Override
	public GuestBookDto getArticle(int articleno) throws Exception {
		return guestBookDao.getArticle(articleno);
	}

	@Override
	public void modifyArticle(GuestBookDto guestBookDto) throws Exception {
		guestBookDao.modifyArticle(guestBookDto);
	}

	@Override
	public void deleteArticle(int articleno) throws Exception {
		guestBookDao.deleteArticle(articleno);
	}

}
