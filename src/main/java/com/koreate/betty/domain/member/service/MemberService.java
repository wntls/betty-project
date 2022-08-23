package com.koreate.betty.domain.member.service;

import org.springframework.stereotype.Service;

import com.koreate.betty.domain.member.dao.MemberRepository;
import com.koreate.betty.domain.member.dto.LoginForm;
import com.koreate.betty.domain.member.vo.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

	private final MemberRepository memberRepository;
	
	public Member loginMember(LoginForm form) {
		String id = form.getMemberId();
		String pw = form.getPw();
		
		String cookie = form.getLoginCookie();
		
		log.info("id = {} , pw = {} , cookie= {}",id,pw,cookie);
		
		
		if (cookie != null) {
			// 쿠키만드는 작업 해줘
			// 나중에 함
		}
		
		//return memberRepository.login(id, pw);
		return null;
	}
}