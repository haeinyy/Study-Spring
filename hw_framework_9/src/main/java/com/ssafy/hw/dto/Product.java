package com.ssafy.hw.dto;

import org.springframework.web.multipart.MultipartFile;

public class Product {
	
	private int seq;
	private String item_code;
	private String item_name;
	private int item_price;
	private String item_corp;
	private String img;
	private String orgimg;
	private MultipartFile file;
	
	public Product() {};
	
	public Product(int seq, String item_code, String item_name, int item_price, String item_corp,String img){
		this( seq,  item_code,  item_name, item_price,  item_corp, img,null);
	}
	
	public Product(int seq, String item_code, String item_name, int item_price, String item_corp,String img, MultipartFile file) {
		this.seq = seq;
		this.item_code = item_code;
		this.item_name = item_name;
		this.item_price = item_price;
		this.item_corp = item_corp;
		this.img = img;
		this.file = file;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getItem_price() {
		return item_price;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public String getItem_corp() {
		return item_corp;
	}

	public void setItem_corp(String item_corp) {
		this.item_corp = item_corp;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getOrgimg() {
		return orgimg;
	}

	public void setOrgimg(String orgimg) {
		this.orgimg = orgimg;
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
		builder.append("Product [seq=").append(seq).append(", item_code=").append(item_code).append(", item_name=")
				.append(item_name).append(", item_price=").append(item_price).append(", item_corp=").append(item_corp)
				.append(", img=").append(img).append(", orgimg=").append(orgimg).append("]");
		return builder.toString();
	}
	
}