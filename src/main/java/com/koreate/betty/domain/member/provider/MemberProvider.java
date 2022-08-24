package com.koreate.betty.domain.member.provider;

import static com.koreate.betty.domain.model.TableConst.MEMBER_TBL;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import com.koreate.betty.domain.member.vo.Member;

public class MemberProvider {

	// 멤버 테이블의 CRUD를 전담

	// 회원가입
	public String register(Member member) {
		return new SQL().INSERT_INTO(MEMBER_TBL)
				.INTO_COLUMNS("id", "pw", "nickname", "name", "gender", "birth", "phone", "addr", "email")
				.INTO_VALUES("#{id}, #{pw}, #{nickname}, #{name}, #{gender}, #{birth}, #{phone}, #{addr}, #{email}")
				.toString();		
	}
	
	// 로그인
	public String login(@Param("id")String id, @Param("pw")String pw) {
		return new SQL().SELECT("*")
				.FROM(MEMBER_TBL)
				.WHERE("id = #{id}").WHERE("pw = #{pw}")
				.toString();
	}
	
	// 아이디 찾기 (이름 + 전화로 회원의 계정 존재 확인)
	public String findId(@Param("name")String name, @Param("phone")String phone) {
		return new SQL().SELECT("id")
				.FROM(MEMBER_TBL)
				.WHERE("name = #{name}")
				.WHERE("phone = #{phone}")
				.toString();
	}
	
	// 비밀번호 변경 전 유저의 정보 확인  : 아이디 + 전화번호로 회원의 계정이 존재하는지 확인
	public String confirmForChangePw(@Param("id")String id, @Param("phone")String phone) {
		return new SQL().SELECT("count(*)")
				.FROM(MEMBER_TBL)
				.WHERE("id = #{id}")
				.WHERE("phone = #{phone}")
				.toString();
	}
	
	
	// 비밀번호 재설정
	public String changePw(@Param("id")String id, @Param("pw")String changePw) {
		return new SQL().UPDATE(MEMBER_TBL)
				.SET("pw = #{pw}")
				.WHERE("id = #{id}")
				.toString();
	}
		
	
	
	
	// 계정 전체 검색 (직원 -> 회원정보 조회)
	public String findAll() {
		return new SQL().SELECT("*")
				.FROM(MEMBER_TBL)
				.toString();
	}

	
	// 계정 한개 검색 (마이페이지/직원 정보)
	public String fineOne(String id) {
		return new SQL().SELECT("*")
				.FROM(MEMBER_TBL)
				.WHERE("id = #{id}")
				.toString();
	}
		
	// 프로필 이미지 업데이트
	public String changeImg(@Param("id")String id, @Param("id")String img) {
		return new SQL().UPDATE(MEMBER_TBL)
				.SET("img = #{img}")
				.WHERE("id = #{id}")
				.toString();
	}
	
	// 계정 삭제(회원 탈퇴)
	public String deleteMember(String id) {
		return new SQL().DELETE_FROM(MEMBER_TBL)
				.WHERE("id = #{id}")
				.toString();
	}
	
}
