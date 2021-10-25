package com.ssafy.movie.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.movie.model.dto.Movie;
import com.ssafy.movie.model.repo.MovieRepo;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepo movieRepo;

	@Override
	public int insert(Movie m) throws Exception {
		return movieRepo.insert(m);
	}

	@Override
	public List<Movie> search() throws Exception {
		return movieRepo.search();
	}

	@Override
	public Movie select(String code) throws Exception {
		return movieRepo.select(code);
	}

	@Override
	public List<Movie> selectTitle(String title) throws Exception {
		return movieRepo.selectTitle(title);
	}

	@Override
	public List<Movie> selectPrice(int price) throws Exception {
		return movieRepo.selectPrice(price);
	}

	@Override
	public int delete(String code) throws Exception {
		return movieRepo.delete(code);
	}

	@Override
	public int update(Movie m) throws Exception {
		return movieRepo.update(m);
	}

}
