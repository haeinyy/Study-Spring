package com.ssafy.word;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // component scan과 나머지 설정이 자동으로 이루어진다
public class WordCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordCloudApplication.class, args);
	}

}
