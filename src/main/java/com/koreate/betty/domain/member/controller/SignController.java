package com.koreate.betty.domain.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreate.betty.domain.member.dto.form.SignInForm;
import com.koreate.betty.domain.member.dto.form.SignUpForm;
import com.koreate.betty.domain.member.service.SignService;
import com.koreate.betty.domain.member.vo.Member;
import com.koreate.betty.domain.model.CookieConst;

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
	public String signUpMember(@Valid SignUpForm form, BindingResult bindingResult, RedirectAttributes rttr) {
		if(bindingResult.hasErrors()) {
			bindingResult.getAllErrors().iterator()
						.forEachRemaining(ex -> log.error("bindingResult = {}",ex));
			return "redirect:/sign/up/member";
		}
		
		int result = signService.signUp(form);
		String message = result != 0 ? "회원가입 완료" : "회원가입 실패";
		rttr.addFlashAttribute("message", message);
		return "redirect:/sign/in";
	}

	@PostMapping("in")
	public String signIn(SignInForm form, HttpSession session, HttpServletResponse response, RedirectAttributes rttr) {
		Member user = signService.signIn(form);
		boolean cookie = form.isLoginCookie();
		if(user == null) { // 사용자에게 알리는 로직 필요	
			rttr.addFlashAttribute("message", "로그인 실패");
			return "redirect:/sign/in";
		}
		session.setAttribute("user", user);
		
		if (cookie) {
			Cookie idCookie = new Cookie(CookieConst.COOKIE_USER, user.getId());
			idCookie.setMaxAge(24 * 60 * 60);
			idCookie.setPath("/");
			response.addCookie(idCookie);
		}
		rttr.addFlashAttribute("message","로그인 성공");
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
