package com.ssafy.word.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "WordDto : 관심단어", description = "관심단어와 비중을 가진 domain class입니다.")
public class WordDto {

	@ApiModelProperty(value = "관심단어")
	private String text;
	@ApiModelProperty(value = "비중")
	private double weight;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
