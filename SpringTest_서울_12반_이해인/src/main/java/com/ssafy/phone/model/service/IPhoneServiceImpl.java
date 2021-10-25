package com.ssafy.phone.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssafy.phone.model.dao.IPhoneDAO;
import com.ssafy.phone.model.dto.Phone;

@Service
public class IPhoneServiceImpl implements IPhoneService {
	
	@Autowired
	private IPhoneDAO iPhoneDAO;

	@Override
	public int insert(Phone p) throws Exception {
		return iPhoneDAO.insert(p);
	}

	@Override
	public List<Phone> search() throws Exception {
		return iPhoneDAO.search();
	}

	@Override
	public Phone select(String num) throws Exception {
		return iPhoneDAO.select(num);
	}

	@Override
	public int delete(String num) throws Exception {
		return iPhoneDAO.delete(num);
	}

}
