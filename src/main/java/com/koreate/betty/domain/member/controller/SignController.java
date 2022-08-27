package com.koreate.betty.domain.member.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.koreate.betty.domain.member.dto.form.SignInForm;
import com.koreate.betty.domain.member.dto.form.SignUpForm;
import com.koreate.betty.domain.member.service.SignService;
import com.koreate.betty.domain.member.vo.Member;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.sdk.message.service.DefaultMessageService;

@Slf4j
@Controller
@RequestMapping("/sign")
@RequiredArgsConstructor
public class SignController {	
	
	private final SignService signService;
	
	
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
	
	@PostMapping("up/member")
	public String signUpMember(@Valid SignUpForm form, BindingResult bindingResult) {
		log.info("signUpMember form = {}", form);
		if(bindingResult.hasErrors()) {
			bindingResult.getAllErrors()
						.iterator()
						.forEachRemaining(ex -> log.error("bindingResult = {}",ex));
			return "redirect:/sign/up/member";
		}
		
		int result = signService.signUp(form);
		log.info("signUpMember result : {} ", result);
		return "redirect:/sign/in";
	}

	@GetMapping("up/staff")
	public String signUpStaff() {
		return "sign/sign-up-staff";
	}

	@PostMapping("in")
	public String signIn(SignInForm form, HttpSession session) {
		log.info("signIn Post form = {} ",form);
		Member user = signService.SignIn(form);
		if(user == null) { // 사용자에게 알리는 로직 필요	
			return "redirect:/sign/in";
		}
		
		session.setAttribute("user", user);
		return "redirect:/";
	}
	

	@GetMapping("up/idCheck")
	@ResponseBody
	public boolean idCheck(String id) { return signService.checkIdDupl(id); }
	
	@GetMapping("up/nicknameCheck")
	@ResponseBody
	public boolean nicknameCheck(String nickname) { return signService.checkIdDupl(nickname); }
	
	
	@GetMapping("find/id")
	@ResponseBody
	public String forgetIdTakeCode(FindIdDto dto, HttpSession session) {
		String code = signService.forgetId(dto.getName(), dto.getPhone());
		session.setAttribute("code", code);
		session.setMaxInactiveInterval(180);
		log.info("아이디 찾기 발급 코드 = {}",code);
		return code;
	}
	
	@PostMapping("find/id")
	@ResponseBody
	public String forgetIdValidCode(FindIdDto dto, @SessionAttribute("code") String code) {
		if(dto.getCode().equals(code)) {
			log.info("사용자가 입력한 코드 = {} , 아이디 찾기 발급 코드 = {}",dto.getCode(),code);
			return signService.forgetId(dto.getName(), dto.getPhone());
		}
		log.info("[ERROR] 사용자가 입력한 코드 = {} , 아이디 찾기 발급 코드 = {}",dto.getCode(),code);
		return "코드가 일치하지 않습니다";
	}
	
	// @@ 로그인 뷰에서 비밀번호 변경 버튼 눌렀을 때 ajax	 service : findForChangePw, changePw

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
