package com.koreate.betty.domain.member.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreate.betty.domain.member.dto.form.UpdateForm;
import com.koreate.betty.domain.member.service.MemberService;
import com.koreate.betty.domain.member.vo.Inquiry;
import com.koreate.betty.infra.email.EmailSender;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members/{id}")
public class MemberApiController {
	
	private final EmailSender emailSender;
	private final MemberService memberService;
	
	@PostMapping("inquiry")
	public String memberSendMail(Inquiry inquiry) {
		if (inquiry == null) {
			throw new RuntimeException("요청 오류");
		}
		emailSender.inquiry(inquiry);
		return "redirect:/members/{memberId}";
	}
	
	@DeleteMapping
	public String deleteMember(@PathVariable String id, RedirectAttributes rttr) {
		int result = memberService.deleteMember(id);
		if(result !=0) {
			return "redirect:/";
		}
		rttr.addFlashAttribute("message", "삭제 실패");
		return "redirect:/members/"+id;
	}
	
	
	
}
