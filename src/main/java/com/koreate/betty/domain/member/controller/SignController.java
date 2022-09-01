package com.koreate.betty.domain.member.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.koreate.betty.domain.member.dto.form.SignInForm;
import com.koreate.betty.domain.member.dto.form.SignUpForm;
import com.koreate.betty.domain.member.service.SignService;
import com.koreate.betty.domain.member.util.Base64Util;
import com.koreate.betty.domain.member.vo.Member;
import com.koreate.betty.domain.model.CookieConst;
import com.koreate.betty.domain.model.SessionConst;

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

	@PostMapping({"up/member", "up/staff"})
	public String signUpMember(@Valid SignUpForm form, BindingResult bindingResult, RedirectAttributes rttr) {
		if (bindingResult.hasErrors()) {
			bindingResult.getAllErrors()
						.iterator()
						.forEachRemaining(ex -> log.error("bindingResult = {}", ex));
			return "redirect:/sign/up/member";
		}
		form.encode();
		int result = signService.signUp(form);
		String message = result != 0 ? "회원가입 완료" : "회원가입 실패";
		rttr.addFlashAttribute("message", message);
		return "redirect:/sign/in";
	}

	@PostMapping("in")
	public String signIn(SignInForm form, HttpSession session, HttpServletResponse response, String redirectURL,
			RedirectAttributes rttr) throws IOException {
		form.encode();
		Member user = signService.signIn(form);
		if (user == null) {
			rttr.addFlashAttribute("message", "로그인 실패");
			return "redirect:/sign/in";
		}
		session.setAttribute("user", user);

		if (form.isLoginCookie()) {
			String encodedId = Base64Util.encode(user.getId());
			Cookie cookie = new Cookie(CookieConst.COOKIE_USER, encodedId);
			cookie.setMaxAge(24 * 60 * 60);
			cookie.setPath("/");
			response.addCookie(cookie);
		}

		if (redirectURL != null) {
			response.sendRedirect(redirectURL);
			return null;
		}

		rttr.addFlashAttribute("message", "로그인 성공");
		return "redirect:/";
	}

	@GetMapping("logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		Member user = (Member) session.getAttribute(SessionConst.USER);
		session.invalidate();
		Cookie findCookie = WebUtils.getCookie(request, CookieConst.COOKIE_USER);
		if (findCookie != null) {
			String encodedId = Base64Util.encode(user.getId());
			Cookie cookie = new Cookie(CookieConst.COOKIE_USER, encodedId);
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		return "redirect:/";
	}

	// @@ 로그인 뷰에서 비밀번호 변경 버튼 눌렀을 때 ajax service : findForChangePw, changePw

}
