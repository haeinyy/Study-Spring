package com.ssafy.movie.model.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.movie.model.dto.Movie;

public interface MovieRepo {
	
	int insert(Movie m) throws Exception;
	List<Movie> search() throws Exception;
	Movie select(String code) throws Exception;
	List<Movie> selectTitle(String title) throws Exception;
	List<Movie> selectPrice(int price) throws Exception;
	int delete(String code) throws Exception;
	int update(Movie m) throws Exception;

}
