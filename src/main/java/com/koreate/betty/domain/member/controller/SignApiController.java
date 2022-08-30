package com.koreate.betty.domain.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.koreate.betty.domain.member.args.Code;
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
	@ResponseBody
	public boolean idCheck(String id) {
		return signService.checkIdDupl(id);
	}

	@GetMapping("up/nicknameCheck")
	@ResponseBody
	public boolean nicknameCheck(String nickname) {
		return signService.checkIdDupl(nickname);
	}

	@GetMapping("up/emailCheck")
	@ResponseBody
	public boolean emailCheck(String email) {
		return signService.checkEmailDupl(email);
	}

	@GetMapping("find/id")
	@ResponseBody
	public String forgetIdTakeCode(FindIdDto dto, HttpSession session) {
		String code = signService.forgetId(dto.getName(), dto.getPhone());
		session.setAttribute("code", code);
		session.setMaxInactiveInterval(180);
		log.info("아이디 찾기 발급 코드 = {}", code);
		return code;
	}

	@PostMapping("find/id")
	@ResponseBody
	public String forgetIdValidCode(FindIdDto dto, @SessionAttribute("code") String code) {
		if (dto.getCode().equals(code)) {
			log.info("사용자가 입력한 코드 = {} , 아이디 찾기 발급 코드 = {}", dto.getCode(), code);
			return signService.forgetId(dto.getName(), dto.getPhone());
		}
		log.info("[ERROR] 사용자가 입력한 코드 = {} , 아이디 찾기 발급 코드 = {}", dto.getCode(), code);
		return "코드가 일치하지 않습니다";
	}

	@GetMapping("up/sms")
	@ResponseBody
	public Map<String, String> sendSMS(String phone, HttpSession session) {
		log.info("=== GET sendSMS = {}", phone);
		Map<String, String> map = new HashMap<String, String>();
		map.put("code", "12345");
		session.setAttribute("code", "12345");
		session.setMaxInactiveInterval(180);
		return map;
	}

	@PostMapping("up/sms")
	@ResponseBody
	public ResponseEntity<Map<String, String>> smsValid(@Code String code) {

		if (code == null) {
			log.info("up/sms code == null = {}", code);
			// throw new RuntimeException("코드 일치 x");
		}

		log.info("up/sms code != null = {}", code);
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "성공!");
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
	}

	@GetMapping("up/email")
	@ResponseBody
	public Map<String, String> sendEmail(String email, HttpSession session) {
		log.info("=== GET sendEmail = {}", email);
		Map<String, String> map = new HashMap<String, String>();
		map.put("code", "12345");
		session.setAttribute("code", "12345");
		session.setMaxInactiveInterval(180);
		return map;
	}

	@PostMapping("up/email")
	@ResponseBody
	public String emailValid(String code, @Code String sessionCode) {
		if (code.equals(sessionCode)) {
			return "namu6747";
		}
		throw new RuntimeException("틀렸다");
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

}
