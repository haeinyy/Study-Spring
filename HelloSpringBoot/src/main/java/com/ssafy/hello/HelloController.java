package com.ssafy.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@GetMapping("/hsb")
	public String hello(Model model) {
		System.out.println("여기오니?");
		model.addAttribute("msg","안녕하세요 스프링부트!");
		return "hello";
	}
	
	@GetMapping("/rest")
	@ResponseBody
	public String hello() {
		return "Springboot REST call!";
	}
}
