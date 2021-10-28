package com.ssafy.mvc.controller;

import java.util.List;
import java.util.Map;

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

import com.ssafy.mvc.model.dto.Emp;
import com.ssafy.mvc.model.service.EmpService;
import com.sun.corba.se.impl.presentation.rmi.ExceptionHandler;

import io.swagger.annotations.ApiOperation;


@RestController // retunr이 될때 모든 것이 ResponseBody로 리턴됨(데이터)
@CrossOrigin("*")
@RequestMapping("/empapi")
public class EmpRestController {
	
	@Autowired
	private EmpService empService;
	
	private ResponseEntity<?> exceptionHandling(Exception e){
		e.printStackTrace(); // 무조건 해주기
		return new ResponseEntity<String>("Exception : "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); //500
	}

	@PostMapping("/emp")
	@ApiOperation(value = "Emp 객체의 목록을 반환합니다", response=Integer.class)
	public ResponseEntity<?> insert(@RequestBody Emp emp) { // @RequestBody : json 데이터를 원하는 타입으로 바인딩
		System.out.println(emp);
		try {
			int result = empService.insert(emp);
			return new ResponseEntity<Integer>(result,HttpStatus.CREATED); // 201
		} catch(Exception e){
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/emp")
	@ApiOperation(value = "Emp 객체의 목록을 반환합니다", response=Emp.class)
	public ResponseEntity<?> search(){
		try {
			List<Emp> emps = empService.search();
			if(emps!=null && emps.size()>0)
				return new ResponseEntity<List<Emp>>(emps,HttpStatus.OK); // 200
			else 
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // 204
		} catch(Exception e){
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/emp/{num}")
	@ApiOperation(value = "{num}에 해당하는 Emp 객체의 정보를 반환합니다", response=Emp.class)
	public ResponseEntity<?> select(@PathVariable int num) {
		try {
			Emp emp = empService.select(num);
			if(emp!=null)
				return new ResponseEntity<Emp>(emp,HttpStatus.OK); // 200
			else 
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // 204
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@DeleteMapping("/emp/{num}")
	@ApiOperation(value = "{num}에 해당하는 Emp 객체의 정보를 삭제합니다", response=Integer.class)
	public ResponseEntity<?> delete(@PathVariable int num) {
		try {
			int result = empService.delete(num);
			if(result==1)
				return new ResponseEntity<Integer>(result,HttpStatus.CREATED); // 201
			else
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // 204
		} catch(Exception e){
			return exceptionHandling(e);
		}
	}
	
	@PutMapping("/emp")
	@ApiOperation(value = "Emp 객체의 정보를 수정합니다", response=Integer.class)
	public ResponseEntity<?> update(@RequestBody Map<String, Integer> map) {
		try {
			int result = empService.update(map);
			if(result==1) // 정상 
				return new ResponseEntity<Integer>(result,HttpStatus.CREATED); // 201
			else // 에러
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // 204
		} catch(Exception e){
			return exceptionHandling(e);
		}
	}; 
	
}
