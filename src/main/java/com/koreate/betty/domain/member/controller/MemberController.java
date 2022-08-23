package com.koreate.betty.domain.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members/{memberId}")
public class MemberController {

	@GetMapping
	public String memberInfo() {
		return "member/member-info";
	}
	
	@GetMapping("dashboard")
	public String memberDashboard() {
		return "member/member-dashboard";
	}
	
	@GetMapping("edit")
	public String memberEdit() {
		return "member/member-edit";
	}
	
	@GetMapping("charge")
	public String memberCharge() {
		return "member/member-charge";
	}
	
	@GetMapping("rentals")
	public String memberRendal() {
		return "member/member-rental-list";
	}
	
}
