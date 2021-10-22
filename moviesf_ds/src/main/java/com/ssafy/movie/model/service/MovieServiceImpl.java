package com.ssafy.movie.model.service;

import java.sql.SQLException;
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
	public int insert(Movie m) throws SQLException {
		return movieRepo.insert(m);
	}

	@Override
	public Movie select(String code) throws SQLException {
		return movieRepo.select(code);
	}

	@Override
	public List<Movie> search() throws SQLException {
		return movieRepo.search();
	}

	@Override
	public List<Movie> selectTitle(String title) throws SQLException {
		return movieRepo.selectTitle(title);
	}

	@Override
	public List<Movie> selectPrice(int price) throws SQLException {
		return movieRepo.selectPrice(price);
	}

	@Override
	public int delete(String code) throws SQLException {
		return movieRepo.delete(code);
	}

	@Override
	public int update(Movie m) throws SQLException {
		return movieRepo.update(m);
	}

}
