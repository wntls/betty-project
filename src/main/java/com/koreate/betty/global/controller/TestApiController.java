package com.koreate.betty.global.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@GetMapping("/test/date")
	public void testDate (@DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
		Timestamp.from(date.toInstant());
	}
		
	@Setter @Getter
	static class Data {
		String code;
		String title;
		String content;
	}

}
