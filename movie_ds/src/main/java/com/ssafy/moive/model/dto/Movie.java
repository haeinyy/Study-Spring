package com.ssafy.moive.model.dto;


public class Movie {
	private String code;
	private String title;
	private int price;
	private String no;
	private String name;

	
	public Movie() {}
	
	public Movie(String code, String title, int price, String no, String name) {
		super();
		this.code = code;
		this.title = title;
		this.price = price;
		this.no = no;
		this.name = name;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
