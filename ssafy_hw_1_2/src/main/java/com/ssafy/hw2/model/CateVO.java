package com.ssafy.hw2.model;

import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class CateVO {
	
	private Map cateMap;
	
	public CateVO() {};

	public CateVO(Map cateMap) {
		super();
		this.cateMap = cateMap;
	}

	public Map getCateMap() {
		return cateMap;
	}

	public void setCateMap(Map cateMap) {
		this.cateMap = cateMap;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CateVO [cateMap=").append(cateMap).append("]");
		return builder.toString();
	}
	
	
}