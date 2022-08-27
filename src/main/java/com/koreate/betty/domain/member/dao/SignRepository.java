package com.koreate.betty.domain.member.dao;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import com.koreate.betty.domain.member.provider.SignProvider;
import com.koreate.betty.domain.member.vo.Member;

@Mapper
public interface SignRepository {

		// 회원가입
		@InsertProvider(type=SignProvider.class, method="create")
		public int create(Member member);
		
		// 아이디 중복 검사
		@SelectProvider(type=SignProvider.class, method="findIdById")
		public String findIdById(String id);
		
		// 닉네임 중복 검사
		@SelectProvider(type=SignProvider.class, method="findNicknameByNickname")
		public String findNicknameByNickname(String nick);
		
		// 이메일 중복 검사
		@SelectProvider(type=SignProvider.class, method="findEmailByEmail")
		public String findEmailByEmail(String email);
		
		// 로그인
		@SelectProvider(type=SignProvider.class, method="findOneBySignIn")
		public Member findOneBySignIn(Member member);
		
		// 아이디 찾기
		@SelectProvider(type=SignProvider.class, method="findIdByForget")
		public String findIdByForget(final String name, final String phone);
		
		// 비밀번호 찾기
		@SelectProvider(type=SignProvider.class, method="findPwByForget")
		public int findPwByForget(@Param("id")String id, @Param("phone")String phone);
	
}
