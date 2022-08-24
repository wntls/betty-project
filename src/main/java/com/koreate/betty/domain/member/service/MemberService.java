package com.koreate.betty.domain.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.koreate.betty.domain.member.dao.MemberRepository;
import com.koreate.betty.domain.member.dto.form.JoinForm;
import com.koreate.betty.domain.member.dto.form.LoginForm;
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
		
		log.info("id = {} , pw = {} , cookie= {}", id, pw, cookie);
		
		
		if (cookie != null) {
			// 쿠키만드는 작업 해줘
			// 나중에 함
		}
		
		return memberRepository.login(id, pw);
	}

	public int joinMember(JoinForm form) {
		
		int result = 0;
		
		String pw = form.getPw();
		String repw = form.getRepw();
		
		if (!pw.equals(repw)) {
			return result;
		}
		
		Member joinMember = form.createMember();
				
		result = memberRepository.register(joinMember);
		return result;
	}
	
	public String findId(String name, String phone) {
		String id = null;
		
		id = memberRepository.findId(name, phone);
				
		return id;
	}
	
	public int confirmForChangePw(String id, String phone) {
		int result = 0;
		
		result = memberRepository.confirmForChangePw(id, phone);
		
		return result;
	}
	
	public int changePw(String id, String pw) {
		int result = 0;
		
		result = memberRepository.changePw(id, pw);
		
		return result;
	}
	
	public List<Member> findAll() {
		List<Member> list = memberRepository.findAll();
		return list;
	}
	
	public int changeImg(String id, String img) {
		int result = 0;
		
		result = memberRepository.changeImg(id, img);
		
		return result;
	}

	public int deleteMember(String id) {
		int result = 0;
		
		result = memberRepository.deleteMember(id);
		
		return result;
	}
	
}