package com.ssafy.movie.model.service;

import java.sql.SQLException;
import java.util.*;

import org.springframework.stereotype.Service;

import com.ssafy.moive.model.dto.Movie;

public interface MovieService {
	int insert(Movie m) throws SQLException;
	Movie select(String code) throws SQLException;
	List<Movie> search() throws SQLException;
	List<Movie> searchTitle(String title) throws SQLException;
	List<Movie> searchPrice(int price) throws SQLException;
	int delete(String code) throws SQLException;
	int update(Movie m) throws SQLException;
}
