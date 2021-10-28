package com.ssafy.guestbook.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.guestbook.model.service.MemberService;

@RestController // @RestquesBody 자동설정
@RequestMapping("/admin")
@CrossOrigin("*")
//@CrossOrigin(origins = {"http://localhost:8000","http://www.kakao.com"})
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private MemberService memberService;
	/*
//	@CrossOrigin(origins = {"http://localhost:8000"})
	@RequestMapping(value = "/user", method = RequestMethod.GET, headers = { "Content-type=application/json" })
	public List<MemberDto> userList() throws Exception {
		List<MemberDto> list = memberService.listMember();
		logger.debug("회원목록 : {}", list);
		return list;
//		return memberService.listMember();
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public List<MemberDto> userRegister(@RequestBody MemberDto memberDto) throws Exception {
		memberService.registerMember(memberDto);
		return memberService.listMember();
	}
	
	@RequestMapping(value = "/user/{userid}", method = RequestMethod.GET, headers = { "Content-type=application/json" })
	public MemberDto userInfo(@PathVariable("userid") String userid) throws Exception {
		return memberService.getMember(userid);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.PUT, headers = { "Content-type=application/json" })
	public List<MemberDto> userModify(@RequestBody MemberDto memberDto) throws Exception {
		memberService.updateMember(memberDto);
		return memberService.listMember();
	}
	
	@RequestMapping(value = "/user/{userid}", method = RequestMethod.DELETE, headers = { "Content-type=application/json" })
	public List<MemberDto> userDelete(@PathVariable("userid") String userid) throws Exception {
		memberService.deleteMember(userid);
		return memberService.listMember();
	}
	*/

	// 조건에 따라서 어떤 상태인지 확인가능하고 예외처리 가능
	@GetMapping(value = "/user")
	public ResponseEntity<List<MemberDto>> userList() throws Exception {
		List<MemberDto> list = memberService.listMember();
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK); // 200
//			return new ResponseEntity<List<MemberDto>>(HttpStatus.NOT_FOUND); // 404 에러 
//			return new ResponseEntity<List<MemberDto>>(HttpStatus.INTERNAL_SERVER_ERROR); // 500 에러 
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping(value = "/user")
	public ResponseEntity<List<MemberDto>> userRegister(@RequestBody MemberDto memberDto) throws Exception {
		memberService.registerMember(memberDto);
		List<MemberDto> list = memberService.listMember();
		return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
//		return new ResponseEntity<Integer>(cnt, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/user/{userid}")
	public ResponseEntity<MemberDto> userInfo(@PathVariable("userid") String userid) throws Exception {
		logger.debug("파라미터 : {}", userid);
		MemberDto memberDto = memberService.getMember(userid);
		if(memberDto != null)
			return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value = "/user")
	public ResponseEntity<List<MemberDto>> userModify(@RequestBody MemberDto memberDto) throws Exception {
		memberService.updateMember(memberDto);
		List<MemberDto> list = memberService.listMember();
		return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/user/{userid}")
	public ResponseEntity<List<MemberDto>> userDelete(@PathVariable("userid") String userid) throws Exception {
		memberService.deleteMember(userid);
		List<MemberDto> list = memberService.listMember();
		return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
	}

}
