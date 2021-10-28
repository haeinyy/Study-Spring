package com.ssafy.ws.dto;

import org.springframework.web.multipart.MultipartFile;

public class Book {
	private String isbn;
	private String title;
	private String author;
	private int price;
	private String content;
	private String img;
	private String orgImg;
	private MultipartFile file;
	
	public Book() {}
	
	public Book(String isbn, String title, String author, int price, String content, String img) {
		this(isbn, title, author, price, content, img, null);
	}
	
	public Book(String isbn, String title, String author, int price, String content, String img, MultipartFile file) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.content = content;
		this.img = img;
		this.file = file;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getOrgImg() {
		return orgImg;
	}
	public void setOrgImg(String orgImg) {
		this.orgImg = orgImg;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [isbn=").append(isbn).append(", title=").append(title).append(", author=").append(author)
				.append(", price=").append(price).append(", content=").append(content).append(", img=").append(img)
				.append(", orgImg=").append(orgImg).append(", file=").append(file).append("]");
		return builder.toString();
	}
	
}
