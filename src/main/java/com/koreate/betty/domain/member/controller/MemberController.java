package com.koreate.betty.domain.member.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreate.betty.domain.member.dto.InquiryForm;
import com.koreate.betty.domain.model.TempConst;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members/{memberId}")
@PropertySource("classpath:/mail.properties")
public class MemberController {

	private final JavaMailSender mailSender;
	
	@Value("${mail.username}")
	private String adminEmail;
	
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
	
	@GetMapping("inquiry")
	public String memberSendMail(InquiryForm form) throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,"UTF-8");
		
		// 현재 보내는 이의 이메일을 변경하지 못함 But, 받는 사람의 이메일은 지정할 수 있음.
		helper.setFrom(adminEmail); 
		helper.setTo(adminEmail);
		
		mailSender.send(message);
		return "redirect:/members/{memberId}";
	}
	
}
