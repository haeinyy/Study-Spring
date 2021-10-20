package com.ssafy.mvc.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.mvc.calc.Calc;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private Calc calc;
	
	@ExceptionHandler(Exception.class)
	public String error(Model m, Exception e) {
		return "error/500";
	}
	
	@GetMapping({"/","/index"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/hello")
	public String hello(int num, Model m) {
		System.out.println("num=["+num+"]");
		m.addAttribute("msg","처리정상! "+num);
		return "result";
	}
	
	@GetMapping("/calc")
	public String calc(Model m) {
		m.addAttribute("title","계산기");
		return "calc";
	}
	
	@PostMapping("/calc")
	public String calc(int n1, @RequestParam("oper") String op, int n2, Model m) {
		int r=0;
		switch(op) {
		case "+": r=calc.plus(n1, n2); break;
		case "-": r=calc.minus(n1, n2); break;
		case "*": r=n1*n2; break;
		case "/": r=n1/n2; break;
		}
		m.addAttribute("msg",n1+op+n2+"="+r);
		return "result";
	}
	
}
