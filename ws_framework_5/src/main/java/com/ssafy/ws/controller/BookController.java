package com.ssafy.ws.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.ssafy.ws.dto.User;

@Controller
public class BookController {
	private static final Logger logger=LoggerFactory.getLogger(BookController.class);

	@Autowired
	ResourceLoader loader;
	
	@GetMapping("/")
	public String index(){ 
		return "index";
	}

	@PostMapping("/login")
	public String login(User user,HttpSession session,Model m) {
		if("ssafy".equals(user.getId()) && "1234".equals(user.getPass())){
			user.setName("김싸피");
			session.setAttribute("userinfo", user);
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
	public String regist(Book book,@RequestPart(required=false) MultipartFile file) throws IllegalStateException, IOException {
		if(file!=null && file.getSize()>0) {
			Resource res=loader.getResource("resources/upload");
			book.setImg(System.currentTimeMillis()+"_"+file.getOriginalFilename());
			book.setOrgImg(file.getOriginalFilename());
			file.transferTo(new File(res.getFile().getCanonicalPath()+"/"+book.getImg()));
		}
		return "regist_result";
	}
	@GetMapping("/list")
	public String list(Model m) {
		List<Book> books = new ArrayList<>();
		books.add(new Book("111-222-3333", "홍길동", "책제목1", 10000, "좋은 책 1", "abc1.png"));
		books.add(new Book("111-222-4444", "임꺽정", "책제목2", 20000, "좋은 책 2", "abc2.png"));
		books.add(new Book("111-333-4444", "장길산", "책제목3", 30000, "좋은 책 3", "abc3.png"));
		m.addAttribute("books", books);
		return "list";
	}
}
