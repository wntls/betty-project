package com.koreate.betty.domain.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staff")
public class StaffController {
	
	@GetMapping
	public String staffMain() {
		return "staff/staff-main";
	}
	
	@GetMapping("{memberId}")
	public String userInfo() {
		return "staff/staff-info";
	}
	
	@GetMapping("members")
	public String staffInfo() {
		return "staff/staff-member-list";
	}
	
	@GetMapping("{memberId}/edit")
	public String staffUpdate() {
		return "staff/staff-edit";
	}
	
	@GetMapping("books")
	public String bookInfo() {
		return "staff/staff-book-list";
	}
	
	@GetMapping("books/new")
	public String newBooks() {
		return "staff/staff-book-new";
	}
	
	@GetMapping("books/{isbn}/edit")
	public String updateBooks() {
		return "staff/staff-book-edit";
	}
	
	@GetMapping("rentals")
	public String rentalList() {
		return "staff/staff-rental-list";
	}
	
}
