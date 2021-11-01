package com.ssafy.ws.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ws.dto.Book;
import com.ssafy.ws.dto.SearchCondition;
import com.ssafy.ws.dto.User;
import com.ssafy.ws.model.service.BookService;
import com.ssafy.ws.model.service.UserService;

@Controller
public class BookController {
	private static final Logger logger=LoggerFactory.getLogger(BookController.class);

	
	@Autowired
	UserService userService;
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/main") // get/post 둘다 요청 들어옴
	public String main() {
		return "main";
	}
	
	@GetMapping("/")
	public String index(){ 
		return "index";
	}
	
	@PostMapping("/login")
	public String login(User user,HttpSession session,Model m) {
		User selected = userService.select(user.getId());
//		if("ssafy".equals(user.getId()) && "1234".equals(user.getPass())){
		if(selected != null && selected.getPass().equals(user.getPass())) {
//			user.setName("김싸피");
//			session.setAttribute("userinfo", user);
			session.setAttribute("userinfo", selected);
			return "redirect:/";
		}else {
			m.addAttribute("msg","로그인 실패");
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
		return "regist";
	}	
	@PostMapping("/regist")
	public String regist(Book book) throws IllegalStateException, IOException {
		bookService.insert(book);
		return "regist_result";
	}
	@GetMapping("/list")
	public String list(SearchCondition condition, Model m) {
//		List<Book> books = new ArrayList<>();
//		List<Book> books = bookService.search(condition);
//		m.addAttribute("books", books);
		Map<String, Object> map = bookService.pagingSearch(condition);
		m.addAttribute("books",map.get("books"));
		m.addAttribute("navigation",map.get("navigation"));
		return "list";
	}
}
