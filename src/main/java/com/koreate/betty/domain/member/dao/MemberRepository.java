package com.koreate.betty.domain.member.dao;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.koreate.betty.domain.member.provider.MemberProvider;
import com.koreate.betty.domain.member.vo.Member;

@Repository
public interface MemberRepository {

	@InsertProvider(type=MemberProvider.class, method="register")
	public void register(Member member);
	
	@SelectProvider(type=MemberProvider.class, method="login")
	public Member login(String id, String pw);
	
	
	
	
}
