package com.koreate.betty.domain.member.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;

import com.koreate.betty.domain.member.provider.MemberCardProvider;

@Mapper
public interface MemberCardRepository {

	@UpdateProvider(type=MemberCardProvider.class, method="updatePoint")
	public int updatePoint(@Param("id")String id, @Param("point")int point);
	
	@UpdateProvider(type=MemberCardProvider.class, method="updateGrade")
	public int updateGrade(@Param("id")String id, @Param("msGrade")String msGrade);
	
	
}
