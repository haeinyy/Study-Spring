package com.ssafy.hw.controller;

import java.io.File;
import java.io.IOException;
import java.util.*;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.hw.dto.*;
import com.ssafy.hw.model.service.ProductService;
import com.ssafy.hw.model.service.UserService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/main")
	public String main() {
		return "main";
	}
	
	@PostMapping("/login")
	public String login(User user, Model m ,HttpSession session) {
		User selected = userService.select(user.getId());
		if(selected != null && selected.getPass().equals(user.getPass())) {
//			user.setName("김싸피");
			session.setAttribute("userinfo", selected);
			return "redirect:/"; // index로 보내기..!?!?
		} else {
			m.addAttribute("msg","로그인실패");
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
	public String regist(Product product) throws IllegalStateException, IOException {
		productService.insert(product);
		return "regist_result";
	}
	
	@GetMapping("/list")
	public String list(SearchCondition condition, Model m) {
		Map<String, Object> map = productService.pagingSearch(condition);
		m.addAttribute("products", map.get("products"));
		m.addAttribute("navigation",map.get("navigation"));
		return "list";
	}
	
}
