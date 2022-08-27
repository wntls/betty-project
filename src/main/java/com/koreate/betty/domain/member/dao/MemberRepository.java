package com.koreate.betty.domain.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import com.koreate.betty.domain.member.provider.MemberProvider;
import com.koreate.betty.domain.member.vo.ChkLog;
import com.koreate.betty.domain.member.vo.Member;

@Repository
public interface MemberRepository {
	
	@SelectProvider(type=MemberProvider.class, method="findAll")
	public List<Member> findAll();
	
	@SelectProvider(type=MemberProvider.class, method="findMyChkLog")
	public List<ChkLog> findMyChkLog(String loginId);
	
	@UpdateProvider(type=MemberProvider.class, method="updateMember")
	public int updateMember(@Param("id")String targetId, @Param("member")Member member);
	
	@UpdateProvider(type=MemberProvider.class, method="changePw")
	public int changePw(@Param("id")String id, @Param("pw")String pw);

	@UpdateProvider(type=MemberProvider.class, method="deleteMember")
	public int deleteMember(String id);
	
	@UpdateProvider(type=MemberProvider.class, method="addPoint")
	public int addPoint(@Param("id")String id, @Param("point")int point);
	
	@UpdateProvider(type=MemberProvider.class, method="updateMembership")
	public int updateMembership(@Param("id")String id, @Param("msGrade")String msGrade);
	
	
}


// 안쓰게 될 것같은 코드 임시 이동
// 완성에 다다를 때 삭제

// @UpdateProvider(type=MemberProvider.class, method="changeImg")
// public int changeImg(@Param("id")String id, @Param("img")String img);