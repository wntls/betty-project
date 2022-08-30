package com.koreate.betty.domain.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.koreate.betty.domain.member.service.SignService;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/sign")
@RequiredArgsConstructor
public class SignApiController {

	private final SignService signService;

	@GetMapping("up/idCheck")
	public boolean idCheck(String id) {
		return signService.checkIdDupl(id);
	}

	@GetMapping("up/nicknameCheck")
	public boolean nicknameCheck(String nickname) {
		return signService.checkIdDupl(nickname);
	}

	@GetMapping("up/emailCheck")
	public boolean emailCheck(String email) {
		return signService.checkEmailDupl(email);
	}

	@GetMapping("find/id")
	public String forgetIdTakeCode(FindIdDto dto, HttpSession session) {
		String code = signService.forgetId(dto.getName(), dto.getPhone());
		session.setAttribute("code", code);
		session.setMaxInactiveInterval(180);
		return code;
	}

	@PostMapping("find/id")
	public String forgetIdValidCode(FindIdDto dto, @SessionAttribute("code") String code) {
		if (dto.getCode().equals(code)) {
			return signService.forgetId(dto.getName(), dto.getPhone());
		}
		return "코드가 일치하지 않습니다";
	}

	@GetMapping("up/sms")
	public String sendSMS(String phone, HttpSession session) {
		signService.sendSMS(phone, session);
		return "SMS 전송 완료";
	}

	@PostMapping("up/sms")
	public String smsValid(String code, HttpSession session) {
		String sessionCode = (String)session.getAttribute("code");
		if(code.equals(sessionCode)) {
			session.invalidate();
			return "일치";
		}
		return "불일치";
	}

	@GetMapping("up/email")
	public String sendEmail(String email, HttpSession session) {
		signService.sendEmail(email, session);
		return "이메일 전송 완료";
	}

	@PostMapping("up/email")
	public String emailValid(String code, HttpSession session) {
		String sessionCode = (String)session.getAttribute("code");
		if(code.equals(sessionCode)) {
			session.invalidate();
			return "일치";
		}
		return "불일치";
	}
	
	@Data
	static class FindIdDto {
		private String name;
		private String phone;
		private String code;
	}
	
	@Data
	static class FindPwDto{
		private String id;
		private String phone;
		private String code;
	}
	
	private void storeCodeInSession(HttpSession session) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("code", "12345");
		session.setAttribute("code", "12345");
		session.setMaxInactiveInterval(180);
	}

}
