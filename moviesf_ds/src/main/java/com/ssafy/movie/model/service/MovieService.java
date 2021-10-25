package com.ssafy.movie.model.service;

import java.util.List;

import com.ssafy.movie.model.dto.Movie;

public interface MovieService {
	
	int insert(Movie m) throws Exception;
	List<Movie> search() throws Exception;
	Movie select(String code) throws Exception;
	List<Movie> selectTitle(String title) throws Exception;
	List<Movie> selectPrice(int price) throws Exception;
	int delete(String code) throws Exception;
	int update(Movie m) throws Exception;

}
