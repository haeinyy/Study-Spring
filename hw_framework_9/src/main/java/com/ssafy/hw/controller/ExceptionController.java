package com.ssafy.hw.controller;

import java.net.BindException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController {

	private Logger logger = LoggerFactory.getLogger(ExceptionController.class);
	
	@ExceptionHandler(Exception.class) // 나머지 처리
	public String handleException(Exception ex, Model model) {
		logger.error("Exception 발생 : {}", ex.getMessage());
		model.addAttribute("errmsg", "처리중 에러 발생!!!");
		if(ex instanceof BindException) {
			model.addAttribute("errmsg","파라미터가 올바르게 전달되었는지 확인하세요.");
		}
		return "error/commonerror";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class) // 404처리
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex, Model model) {
		logger.error("404 발생 : {}", "404 page not found");
		model.addAttribute("errmsg", "요청하신 파일은 존재하지 않습니다");
		return "error/404";
	}
	
}

