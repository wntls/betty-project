package com.koreate.betty.domain.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.koreate.betty.domain.board.dto.form.FreeBoardForm;

import com.koreate.betty.domain.member.dto.form.JoinForm;
import com.koreate.betty.domain.member.dto.form.LoginForm;

import com.koreate.betty.domain.member.service.MemberService;
import com.koreate.betty.domain.member.vo.Member;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;

@Slf4j
@Controller
@RequestMapping("/sign")
@RequiredArgsConstructor

public class SignController {	

	
	private final DefaultMessageService messageService;
	private final MemberService memberService;
	private final JavaMailSender mailSender;
	
	@GetMapping("in")
	public String signIn() {
		return "sign/sign-in";
	}

	@GetMapping("up")
	public String signUpChoose() {
		return "sign/sign-up-choose";
	}

	@GetMapping("up/member")
	public String signUpMember() {
		return "sign/sign-up-member";
	}

	@GetMapping("up/staff")
	public String signUpStaff() {
		return "sign/sign-up-staff";
	}

	@PostMapping("in")
	public String signIn(LoginForm form, HttpSession session) {
		Member loginMember = memberService.loginMember(form);
		session.setAttribute("loginMember", loginMember);
		return "redirect:/";
	}

  // 내부 로직 빼낼 예정
	@PostMapping("sms")
	@ResponseBody
	public Map<String, String> sendSMS(String phone) throws Exception {
		// code 생성
		String code = "";
		for (int i = 0; i < 5; i++) {
			code += (int) (Math.random() * 10);
		}

		Message message = new Message();
		message.setFrom("01045725901");
		message.setTo("01000000000"); // message.setTo(phone);
		message.setText("테스트 전송 메세지 입니다.해당 인증번호는[" + code + "]입니다.");

		SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));

		Map<String, String> map = new HashMap<>();
		map.put("code", code);
		map.put("result", response.getStatusCode());
		return map;
	}

	@GetMapping("up/idCheck")
	@ResponseBody
	public boolean isCheck(String id) {
		boolean isCheck = false;
		if (id != null && !id.equals("admin")) {
			isCheck = true;
		}
		return isCheck;
	}
	
	@GetMapping("/checkEmail")
	@ResponseBody
	public String checkEmail(
			@RequestParam("email") String email
			) throws Exception{
		System.out.println(email);
		String code = "";
		
		for(int i=0; i<5; i++) {
			code +=(int)(Math.random()*10);
		}
		
		MimeMessage mesage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mesage,"UTF-8");
		helper.setFrom("show5901@gmail.com");
		helper.setTo(email);
		helper.setSubject("이메일 인증 코드 확인");
		helper.setText("왜 코드 뭐는 되고 뭔는 안되는데!! ["+code+"]", true);
		mailSender.send(mesage);
		System.out.println("발신 완료");
		
		return code;
	}

	//@PostMapping("up/member")
	public String signUpMember(JoinForm form) {

		int result = memberService.joinMember(form);
		
		log.info("signUpMember result : {} ", result);
		return "redirect:/";
	}

	
}

