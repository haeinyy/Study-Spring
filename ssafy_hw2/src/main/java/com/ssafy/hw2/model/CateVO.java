package com.ssafy.hw2.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class CateVO {
	
	private int cate_seq;
	private int cate_name;
	
	public CateVO() {};
	
	public CateVO(int cate_seq, int cate_name) {
		super();
		this.cate_seq = cate_seq;
		this.cate_name = cate_name;
	}

	public int getCate_seq() {
		return cate_seq;
	}

	public void setCate_seq(int cate_seq) {
		this.cate_seq = cate_seq;
	}

	public int getCate_name() {
		return cate_name;
	}

	public void setCate_name(int cate_name) {
		this.cate_name = cate_name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CateVO [cate_seq=").append(cate_seq).append(", cate_name=").append(cate_name).append("]");
		return builder.toString();
	}
	
	
	
	
	
}