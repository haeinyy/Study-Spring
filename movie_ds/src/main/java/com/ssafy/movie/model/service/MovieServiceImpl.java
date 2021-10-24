package com.ssafy.movie.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.moive.model.dto.Movie;
import com.ssafy.movie.model.repo.MovieRepo;
@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	MovieRepo repo;
	@Override
	public int insert(Movie m) throws SQLException {
		return repo.insert(m);
	}

	@Override
	public Movie select(String code) throws SQLException {
		return repo.select(code);
	}

	@Override
	public List<Movie> search() throws SQLException {
		return repo.search();
	}

	@Override
	public List<Movie> searchTitle(String title) throws SQLException {
		return repo.searchTitle(title);
	}

	@Override
	public List<Movie> searchPrice(int price) throws SQLException {
		return repo.searchPrice(price);
	}

	@Override
	public int delete(String code) throws SQLException {
		return repo.delete(code);
	}

	@Override
	public int update(Movie m) throws SQLException {
		return repo.update(m);
	}

}
