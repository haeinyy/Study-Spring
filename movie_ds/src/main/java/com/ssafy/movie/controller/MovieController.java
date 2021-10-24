package com.ssafy.movie.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.moive.model.dto.Movie;
import com.ssafy.moive.model.dto.User;
import com.ssafy.movie.model.service.MovieService;
import com.ssafy.movie.model.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MovieController {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	UserService usvc;
	@Autowired
	MovieService msvc;
	
	@ExceptionHandler(Exception.class)
	public String handler(Model m, Exception e) {
		m.addAttribute("msg", e.getCause());
		return "error/500";
	}
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@PostMapping("/login")
	public String login(User user, HttpSession session, Model m) throws SQLException {
		System.out.println(user.getPass());
		User u = usvc.select(user.getId());
		System.out.println(u.getPass());
		
		if(u!=null && u.getPass().equals(user.getPass())) {
			session.setAttribute("userinfo", u);
			return "redirect:/regist";
		}else {
			m.addAttribute("msg", "로그인 실패");
			return "index";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/regist")
	public String regist() {
		return "movie/regist";
	}
	@PostMapping("/regist")
	public String regist(Movie movie, Model m) throws SQLException {
		msvc.insert(movie);
		m.addAttribute("result", movie.getTitle()+" 등록 완료");
		return "redirect:/list";
	}
	
	@GetMapping("/list")
	public String list(String key, String word, Model m) throws SQLException{
		if(key == null) key ="";
		if(word == null) word = "";
		List<Movie> movies = null;
		switch(key) {
			case "TITLE":
				movies = msvc.searchTitle(word);
				break;
			case "PRICE":
				movies = msvc.searchPrice(Integer.parseInt(word));
				break;
			default:
				movies = msvc.search();
				word="";
				break;
			
		}
		m.addAttribute("key",key);
		m.addAttribute("word",word);
		m.addAttribute("movies",movies);
		return "movie/list";
	}
	
	@GetMapping("/view")
	public String view(String code, Model m) throws SQLException{
		Movie movie = msvc.select(code);
		m.addAttribute("movie", movie);
		
		return "movie/view";
	}
	@GetMapping("/dele")
	public String dele(String code) throws SQLException{
		msvc.delete(code);
		return "redirect:/list";
	}
	@PostMapping("/delem")
	public String delem(String[] codes) throws SQLException{
		for(String code : codes) {
			msvc.delete(code);	
		}
		return "redirect:/list";
	}
	@GetMapping("/desc")
	public String desc(String code, Model m) throws SQLException{
		Movie mv = msvc.select(code);
		m.addAttribute("title", mv.getTitle()+", "+mv.getNo());
		
		return "desc";
	}
}
