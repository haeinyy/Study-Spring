package com.ssafy.phone.model.dto;

public class Phone {
	
	private String num;
	private String model;
	private int price;
	private String vcode; // foreign key
	private String vendor;
	
	public Phone() {};
	
	public Phone(String num, String model, int price, String vcode,String vendor) {
		super();
		this.num = num;
		this.model = model;
		this.price = price;
		this.vcode = vcode;
		this.vendor = vendor;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	
	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Phone [num=").append(num).append(", model=").append(model).append(", price=").append(price)
				.append(", vcode=").append(vcode).append(", vendor=").append(vendor).append("]");
		return builder.toString();
	}

	

}
