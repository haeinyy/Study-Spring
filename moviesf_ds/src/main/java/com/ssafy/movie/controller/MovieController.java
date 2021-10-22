package com.ssafy.movie.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.movie.model.service.MovieService;
import com.ssafy.movie.model.service.UserService;


@Controller
public class MovieController {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MovieService movieService;
	
	@ExceptionHandler(Exception.class)
	public String handler(Model m, Exception e) {
		m.addAttribute("msg",e.getCause());
		System.out.println("e.getCause()=["+e.getCause()+"]");
//		m.addAttribute("msg",e.getMessage());
		System.out.println("e.getMessage()=["+e.getMessage()+"]");
		
//		m.addAttribute("msg","서버 오류 발생! 다시 시도해주세요");
		if(e instanceof SQLIntegrityConstraintViolationException) {
			m.addAttribute("msg","등록 중 오류가 발생");
		}
		e.printStackTrace();
		return "error/500"; // commonerror 
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	
}
