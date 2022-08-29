package com.koreate.betty.domain.member.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreate.betty.domain.book.service.BookService;
import com.koreate.betty.domain.member.dto.form.InquiryForm;
import com.koreate.betty.domain.member.dto.form.UpdateForm;
import com.koreate.betty.domain.member.service.MemberService;
import com.koreate.betty.domain.member.vo.ChkLog;
import com.koreate.betty.domain.member.vo.Member;
import com.koreate.betty.domain.rental.service.RentalService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members/{id}")
@PropertySource("classpath:/mail.properties")
public class MemberController {

	private final JavaMailSender mailSender;
	private final MemberService memberService;
	private final RentalService rentalService;
	
	@Value("${mail.username}")
	private String adminEmail;
	
	@GetMapping
	public String memberInfo(@PathVariable String id, Model model) {
		return "member/member-info";
	}
	
	@GetMapping("dashboard")
	public String memberDashboard(@PathVariable(name = "memberId")String id, Model model, HttpSession session) {	
		// 필요한 정보 목록
		// 회원 정보 (등급, 아이디 출력)
		// 회원 체크인 이력
		// 회원 대여 정보
		// 회원 예약 정보
		
		Member loginMember = (Member)session.getAttribute("loginMember");
		if (loginMember == null) {
			System.out.println("로그인 멤버 null \n\n\n\n");
		}
		
		
		if (loginMember == null || !loginMember.getId().equals(id)) {
			System.out.println("불일치\n\n\n");
		//	return "redirect:/";	// 잘못된 접근은 일단 홈으로
		}
		
		model.addAttribute("grade", memberService.findGradeById(id));
		
		List<ChkLog> chkList = memberService.findMyChkLog(id);
		model.addAttribute("chkList", chkList);
		
		// 회원 대여 정보 : book provider의 rental 참조 (현재 미구현)
		model.addAttribute("rentalList", rentalService.rentalByMemberId(id));
		
		// 회원 예약 정보 : book provider의 reserve 참조 (현재 미구현)
		model.addAttribute("reserveList", rentalService.reserveByMemberId(id));
		
		
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
	
	@PostMapping("edit")
	public String memberInfoEdit(UpdateForm form) {
		
		String targetId = form.getMemberId();
		
		boolean uploaded = memberService.imgUpload(targetId, form.getImg());
		int result = memberService.updateMember(targetId, form);
				
		return "redirect:/members/{memberId}";
	}
	
	@PostMapping("membership")
	public String registerMembership(@PathVariable String memberId, String id, String membershipGrade) {
		int result = memberService.updateMembership(id, membershipGrade);
		return "redirect:/members/"+memberId;
	}
	
	@PostMapping("del")
	public String deleteMember(String id) {
		int result = memberService.deleteMember(id);
		return "redirect:/home";
	}
	
	
	
}
