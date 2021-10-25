package com.ssafy.phone.controller;

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

import com.ssafy.phone.model.dto.*;
import com.ssafy.phone.model.service.*;


@Controller
public class PhoneController {
	
	private static final Logger logger = LoggerFactory.getLogger(PhoneController.class);
	
	@Autowired
	private IPhoneService iPhoneService;
	
	@Autowired
	private UserService userService;
	
	@ExceptionHandler
	public String handler(Model m, Exception e) {
		m.addAttribute("msg",e.getCause());
		return "error/error";
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/login")
	public String login(User user, HttpSession session, Model m) throws Exception {
		// 입력한 패스워드 
		System.out.println(user.getPw());
		// 들어온 유저로 아이디 확인
		User u = userService.select(user.getId()); // 입력한아이디로 db정보가져옴
		System.out.println(u.getId());
		
		if(u!=null && u.getId().equals(user.getId())) { // 데이터 pass와 입력한 pass 비교
			session.setAttribute("userinfo", u);
			return "redirect:/";
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
		return "phone/PhoneReg";
	}
	
	@PostMapping("/regist")
	public String regist(Phone phone, Model m) throws Exception {
		iPhoneService.insert(phone);
		m.addAttribute("result", phone.getNum()+" 등록 완료");
		return "redirect:/result";
	}
	
	@GetMapping("/result")
	public String result() {
		return "result";
	}
	
	@GetMapping("/list")
	public String list(Model m) throws Exception {
		List<Phone> phones = null;
		phones = iPhoneService.search();
		m.addAttribute("phones",phones);
		return "phone/list";
	}
	
	@GetMapping("/view")
	public String view(String num, Model m) throws Exception{
		Phone phone = iPhoneService.select(num);
		m.addAttribute("phone", phone);
		return "phone/view";
	}
	
	@GetMapping("/dele")
	public String dele(String num) throws Exception{
		iPhoneService.delete(num);
		return "redirect:/list";
	}
	
	@PostMapping("/delem")
	public String delem(String[] nums) throws Exception{
		for(String num : nums) {
			iPhoneService.delete(num);	
		}
		return "redirect:/list";
	}
	
}
