package com.koreate.betty.global.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library/")
public class LibraryController {

	// 찾아오는 길
	@GetMapping("route")
	public String route() {
		return "library/route";
	}
	
	// 이용시간 안내
	@GetMapping("time")
	public String time() {
		return "library/time";
	}
	
	// 편의시설
	@GetMapping("facilities")
	public String facilities() {
		return "library/facilities";
	}

	// 멤버십 안내
	@GetMapping("membership")
	public String membership() {
		return "library/membership";
	}
	
	// 스터디름 포화 상태
	@GetMapping("room")
	public String room() {
		return "library/room";
	}
	
	
	
}
