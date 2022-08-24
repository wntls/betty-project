package com.koreate.betty.domain.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import com.koreate.betty.domain.member.provider.MemberProvider;
import com.koreate.betty.domain.member.vo.Member;

@Repository
public interface MemberRepository {

	@InsertProvider(type=MemberProvider.class, method="register")
	public int register(Member member);
	
	@SelectProvider(type=MemberProvider.class, method="login")
	public Member login(@Param("id")String id, @Param("pw")String pw);
	
	@SelectProvider(type=MemberProvider.class, method="findId")
	public String findId(@Param("name")String name, @Param("phone")String phone);
	
	@SelectProvider(type=MemberProvider.class, method="confirmForChangePw")
	public int confirmForChangePw(@Param("id")String id, @Param("phone")String phone); 
	
	@UpdateProvider(type=MemberProvider.class, method="changePw")
	public int changePw(@Param("id")String id, @Param("pw")String pw);

	@SelectProvider(type=MemberProvider.class, method="findAll")
	public List<Member> findAll();

	@UpdateProvider(type=MemberProvider.class, method="changeImg")
	public int changeImg(@Param("id")String id, @Param("img")String img);

	@DeleteProvider(type=MemberProvider.class, method="deleteMember")
	public int deleteMember(String id);
		
}
