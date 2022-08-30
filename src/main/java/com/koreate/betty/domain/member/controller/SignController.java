package com.koreate.betty.domain.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.koreate.betty.domain.member.args.Code;
import com.koreate.betty.domain.member.dto.form.SignInForm;
import com.koreate.betty.domain.member.dto.form.SignUpForm;
import com.koreate.betty.domain.member.service.SignService;
import com.koreate.betty.domain.member.vo.Member;
import com.koreate.betty.domain.model.CookieConst;
import com.koreate.betty.global.error.ErrorResult;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
	
	@GetMapping("up/staff")
	public String signUpStaff() {
		return "sign/sign-up-staff";
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

	@PostMapping("in")
	public String signIn(SignInForm form, HttpSession session, HttpServletResponse response) {
		Member user = signService.signIn(form);
		boolean cookie = form.isLoginCookie();
		if(user == null) { // 사용자에게 알리는 로직 필요	
			return "redirect:/sign/in";
		}
		session.setAttribute("user", user);
		
		if (cookie) {
			Cookie idCookie = new Cookie(CookieConst.COOKIE_USER, user.getId());
			idCookie.setMaxAge(60 * 60 * 60);
			idCookie.setPath("/");
			response.addCookie(idCookie);
		}
		return "redirect:/";
	}
	
	@GetMapping("logout")
	public String logout(
			HttpServletRequest request,
			HttpServletResponse response
			) {
		signService.logout(request, response);
		return "redirect:/";
	}
	
	// @@ 로그인 뷰에서 비밀번호 변경 버튼 눌렀을 때 ajax	 service : findForChangePw, changePw
	
}
