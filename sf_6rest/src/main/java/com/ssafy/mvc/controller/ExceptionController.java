package com.ssafy.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * Handles requests for the application home page.
 */
@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(Exception.class)
	public String error(Model m, Exception e) {
		m.addAttribute("msg", e.getMessage());
		e.printStackTrace();
		return "error/500";
	}

}
