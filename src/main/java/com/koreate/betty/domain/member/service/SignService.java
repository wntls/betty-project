package com.koreate.betty.domain.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreate.betty.domain.member.dao.SignRepository;
import com.koreate.betty.domain.member.dto.form.signUpForm;
import com.koreate.betty.domain.member.dto.form.SignInForm;
import com.koreate.betty.domain.member.vo.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignService {

	@Autowired SignRepository signRepository;
	
	// 회원가입
	public int signUp(signUpForm form) {
		
		int result = 0;
		
		String pw = form.getPw();
		String repw = form.getRepw();
		
		if (!pw.equals(repw)) {
			return result;
		}
		
		Member joinMember = form.convertToMember();
				
		result = signRepository.create(joinMember);
		return result;
	}
	
	// 로그인
	public Member SignIn(SignInForm form) {
		Member member = form.convertToMember();
		String cookie = form.getLoginCookie();
		
		
		member = signRepository.findOneBySignIn(member);
		
		// cookie true or null
		
		if (cookie != null) {
			
		}
		return null;
	}
	
	
	// 아이디 중복 체크
	public boolean checkIdDupl(String id) {
		return isDupl(signRepository.findIdById(id));
	}
	
	// 닉네임 중복 체크
	public boolean checkNicknameDupl(String nick) {
		return isDupl(signRepository.findNicknameByNickname(nick));
	}
	
	// 이메일 중복 체크
	public boolean checkEmailDupl(String email) {
		return isDupl(signRepository.findEmailByEmail(email));
	}
	
	// 아이디 찾기
	public String forgetId(String name, String phone) {
		return signRepository.findIdByForget(name, phone);
	}
	
	// 비밀번호 찾기
	public int forgetPw(String id, String phone) {
		return signRepository.findPwByForget(id, phone);
	}
	
	// 중복 검사 결과
	private boolean isDupl(String target) {
		return target != null ? true : false;
	}
}
