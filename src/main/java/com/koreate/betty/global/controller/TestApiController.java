package com.koreate.betty.global.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TestApiController {
	
	@PutMapping("/staff/books/plz")
	public Data testBook(@RequestBody String code) {
		log.info("code = {}", code);
		Data data = new Data();
		data.setCode(code);
		data.setTitle("모달 에이잭스 실험");
		data.setContent("모달 실험 성공?");
		return data;
	}
	
	@Setter
	@Getter
	static class Data {
		
		String code;
		String title;
		String content;
		
	}

}
