package com.ssafy.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.mvc.model.dto.Emp;
import com.ssafy.mvc.model.service.EmpService;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	private EmpService empService;

	@GetMapping("/list")
	public String list(Model m) {
		m.addAttribute("emps",empService.search());
		return "emp/list";
	}
	
	@GetMapping("/regist")
	public String regist() {
		return "emp/regist";
	}
	
	@PostMapping("/regist")
	public String regist(Emp emp) {
		empService.insert(emp);
		return "redirect:/emp/list";
	}
	
	@GetMapping("/view")
	public String view(int num, Model m) {
		m.addAttribute("emp", empService.select(num));
		return "emp/view"; 
	}
	
	@GetMapping("/dele")
	public String dele(int num) {
		empService.delete(num);
		return "redirect:/emp/list";
	}
}
