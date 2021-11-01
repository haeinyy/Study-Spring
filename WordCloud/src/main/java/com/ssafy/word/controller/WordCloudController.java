package com.ssafy.word.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.word.model.WordDto;
import com.ssafy.word.model.service.WordService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/word")
@Api("Word Cloud Controller API")
public class WordCloudController {

	private static final Logger logger = LoggerFactory.getLogger(WordCloudController.class);
	
	@Autowired
	private WordService wordService;
	
	@ApiOperation(value = "관심단어 목록", notes = "회원들의 <b>관심단어의 목록</b>을 리턴합니다.")
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공!!!"),
		@ApiResponse(code = 404, message = "Not found page !!"),
		@ApiResponse(code = 500, message = "Server Error!!!")
		
	})
	@GetMapping("/")
	public ResponseEntity<List<WordDto>> listWord() {
		logger.debug("listWord - 호출");
		return new ResponseEntity<>(wordService.listWord(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "관심단어 등록", notes = "회원들의 <b>관심단어를</b>을 등록합니다.")
	@PostMapping("/")
	public ResponseEntity<List<WordDto>> registWord(@RequestParam(value = "concerns[]") List<String> concerns) {
		logger.debug("registWord - 호출");
		wordService.registWord(concerns);
		return new ResponseEntity<>(wordService.listWord(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "관심단어 수정", notes = "회원들의 <b>관심단어를</b>을 수정합니다.")
	@PostMapping("{word}")
	public ResponseEntity<List<WordDto>> updateWordCount(@PathVariable("word") String word) {
		logger.debug("updateWordCount - 호출");
		wordService.updateCount(word);
		return new ResponseEntity<>(wordService.listWord(), HttpStatus.OK);
	}
	
}
