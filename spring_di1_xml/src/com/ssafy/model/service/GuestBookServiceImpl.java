package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.GuestBookDto;
import com.ssafy.model.dao.GuestBookDao;

public class GuestBookServiceImpl implements GuestBookService {
	
	private GuestBookDao guestBookDao;
	
	// GuestBookService는 GuestBookDao가 필요한데 여기서 생성하지 않고 
	// 어디선가(applicationContext.xml) 주입이 되어서 dao쓰고있음 
	// property로 사용함 !
	public void setGuestBookDao(GuestBookDao guestBookDao) {
		this.guestBookDao = guestBookDao;
	}

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
