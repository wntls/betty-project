package com.koreate.betty.domain.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.koreate.betty.domain.member.dao.MemberRepository;
import com.koreate.betty.domain.member.dto.form.JoinForm;
import com.koreate.betty.domain.member.dto.form.LoginForm;
import com.koreate.betty.domain.member.dto.form.PointForm;
import com.koreate.betty.domain.member.dto.form.UpdateForm;
import com.koreate.betty.domain.member.vo.ChkLog;
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
				
		result = memberRepository.join(joinMember);
		return result;
	}
	
	public String findId(String name, String phone) {
		String id = null;
		
		id = memberRepository.findId(name, phone);
				
		return id;
	}
	
	public int findForChangePw(String id, String phone) {
		int result = 0;
		
		result = memberRepository.findForChangePw(id, phone);
		
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

	public int deleteMember(String id) {
		int result = 0;
		
		result = memberRepository.deleteMember(id);
		
		return result;
	}

	public int updateMember(String targetId, UpdateForm form) {
		Member update = form.createMember();
		int result = memberRepository.updateMember(targetId, update); 
		
		return result;
	}

	public int addPoint(PointForm form) {
		String id = form.getId();
		int point = form.getPoint();
		int result = memberRepository.addPoint(id, point);
		return result;
	}

	public List<ChkLog> findMyChkLog(String id) {
		return memberRepository.findMyChkLog(id);
	}
	
}