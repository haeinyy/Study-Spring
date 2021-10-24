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

import com.ssafy.movie.model.dto.Movie;
import com.ssafy.movie.model.dto.User;
import com.ssafy.movie.model.repo.MovieRepoImpl;
import com.ssafy.movie.model.service.MovieService;
import com.ssafy.movie.model.service.UserService;


@Controller
public class MovieController {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MovieService movieService;
	
	@ExceptionHandler
	public String handler(Model m, Exception e) {
		m.addAttribute("msg",e.getCause());
		return "error/500";
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/login")
	public String login(User user, HttpSession session, Model m) throws Exception {
		// 입력한 패스워드 
		System.out.println(user.getPass());
		// 들어온 유저로 아이디 확인
		User u = userService.select(user.getId()); // 입력한아이디로 db정보가져옴
		System.out.println(u.getPass());
		
		if(u!=null && u.getPass().equals(user.getPass())) { // 데이터 pass와 입력한 pass 비교
			session.setAttribute("userinfo", u);
			return "redirect:/regist";
		} else {
			m.addAttribute("msg","로그인실패!");
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
	public String regist(Movie movie, Model m) throws Exception {
		movieService.insert(movie);
		m.addAttribute("result", movie.getTitle()+" 등록 완료");
		return "redirect:/list";
	}
	
	@GetMapping("/list")
	public String list(String key, String word, Model m) throws Exception {
		// nullpointexception 방지 
		if(key==null) key="";
		if(word==null) word="";
		
		List<Movie> movies = null;
		switch (key) {
		case "TITLE":
			movies = movieService.selectTitle(word);
			break;
		case "PRICE":
			movies = movieService.selectPrice(Integer.parseInt(word));
			break;
		default:
			movies = movieService.search();
			word="";
			break;
		}
		m.addAttribute("key",key);
		m.addAttribute("word",word);
		m.addAttribute("movies",movies);
		return "movie/list";
	}
	
	@GetMapping("/view")
	public String view(String code, Model m) throws Exception{
		Movie movie = movieService.select(code);
		m.addAttribute("movie", movie);
		return "movie/view";
	}
	
	@GetMapping("/dele")
	public String dele(String code) throws Exception{
		movieService.delete(code);
		return "redirect:/list";
	}
	
	@PostMapping("/delem")
	public String delem(String[] codes) throws Exception{
		for(String code : codes) {
			movieService.delete(code);	
		}
		return "redirect:/list";
	}
	
	@GetMapping("/desc")
	public String desc(String code, Model m) throws Exception{
		Movie mv = movieService.select(code);
		m.addAttribute("title", mv.getTitle()+", "+mv.getNo());
		
		return "desc";
	}
}
